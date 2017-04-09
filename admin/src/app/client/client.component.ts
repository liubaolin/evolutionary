import {Component, Inject, OnDestroy} from '@angular/core';
import {Image} from '../domain/entities';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss','../styles/variables.scss','../styles/mixins/index.scss']
})
export class ClientComponent implements OnDestroy {

  slides: Image[] = [];
  photo = '/assets/index.jpg';
  subscription: Subscription;


  constructor(@Inject('bing') private bingService) {
   /* this.bingService.getImageUrl()
      .subscribe((images:Image[]) => {
        this.slides = [...images];
        this.rotateImages(this.slides);
      });*/
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  rotateImages(arr:Image[]) {
    const length = arr.length
    let i = 0;
    setInterval(() => {
      i = (i + 1) % length;
      this.photo = this.slides[i].contentUrl;
    }, 4000);
  }

}

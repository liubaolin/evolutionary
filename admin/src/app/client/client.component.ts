import {Component, Inject, OnInit} from '@angular/core';
import {Image} from '../domain/entities';
import { Subscription } from 'rxjs/Subscription';
import { Router, ActivatedRoute, Params } from '@angular/router';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss','../styles/variables.scss','../styles/mixins/index.scss']
})
export class ClientComponent implements  OnInit{

  slides: Image[] = [];
  photo = '/assets/index.jpg';
  subscription: Subscription;


  constructor(    private route: ActivatedRoute,
                  private router: Router,
                @Inject('bing') private bingService) {
   /* this.bingService.getImageUrl()
      .subscribe((images:Image[]) => {
        this.slides = [...images];
        this.rotateImages(this.slides);
      });*/
  }

  changeRoute(route:string,id){
    let routeAry = [route];
    if(id){
      routeAry.push(id);
    }
    this.router.navigate(routeAry);
  }

  ngOnInit() {
    console.log(this.route.params);
  }

  // ngOnDestroy() {
  //   // this.subscription.unsubscribe();
  // }
  //
  // rotateImages(arr:Image[]) {
  //   const length = arr.length
  //   let i = 0;
  //   setInterval(() => {
  //     i = (i + 1) % length;
  //     this.photo = this.slides[i].contentUrl;
  //   }, 4000);
  // }
  //
  // onSelect(menu:string){
  //
  // }


}

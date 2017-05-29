import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-news-center',
  templateUrl: './news-center.component.html',
  styleUrls: ['./news-center.component.css']
})
export class NewsCenterComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    console.log(this.route.params);
  }

}

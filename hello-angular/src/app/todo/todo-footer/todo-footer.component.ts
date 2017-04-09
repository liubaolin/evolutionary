import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-todo-footer',
  templateUrl: './todo-footer.component.html',
  styleUrls: ['./todo-footer.component.css']
})
export class TodoFooterComponent implements OnInit {

  constructor() { }
  //声明itemCount是可以一个可输入值（从引用者处）
  @Input() itemCount: number;

  ngOnInit() {
  }

}

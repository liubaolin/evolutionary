import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {TodoVo} from "../todoVo.component";

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  _todos:TodoVo[] = [];

  @Input()
  set todos(todos:TodoVo[]){
    this._todos = [...todos];
  }

  get todos(){
    return this._todos;
  }

  @Output() onDeleteTodo = new EventEmitter<TodoVo>();
  @Output() onToggleTodo = new EventEmitter<TodoVo>();

  constructor() { }

  ngOnInit() {
  }

  onToggleTriggered(todo:TodoVo){
    this.onToggleTodo.emit(todo);
  }

  onRemoveTriggered(todo:TodoVo){
    this.onDeleteTodo.emit(todo);
  }

}

import {Component, OnInit, Inject} from '@angular/core';
import {TodoVo} from './todoVo.component';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css'],
})
export class TodoComponent implements OnInit {

  todos:TodoVo[] = [];
  desc = '';

  constructor(@Inject('todoService') private service,
              private route:ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.forEach((params:Params) => {
      let filter = params['filter'];
      console.log(filter)
      this.filterTodos(filter);
    })
  }

  addTodo() {
    this.service.addTodo(this.desc)
      .then(todo => {
        this.todos = [...this.todos, todo];
        this.desc = '';
      })
    this.desc = '';
  }

  toggleTodo(todo:TodoVo) {
    const i = this.todos.indexOf(todo);
    this.service.toggleTodo(todo)
      .then(t => [...this.todos.slice(0, i),
        t,
        ...this.todos.slice(i + 1)]);
  }

  deleteTodo(todo:TodoVo) {
    const i = this.todos.indexOf(todo);
    this.service.deleteTodoByid(todo.id)
      .then(() => {
        this.todos = [...this.todos.slice(0, i), ...this.todos.slice(i + 1)]
      });
  }

  getTodos():void {
    this.service.getTodos()
      .then(todos => this.todos = [...todos]);
  }

  filterTodos(filter:string):void{
    this.service.filterTodos(filter)
      .then(todos => this.todos = [...todos]);
  }

  onTextChanges(value) {
    this.desc = value;
  }

}

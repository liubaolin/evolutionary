import {Injectable} from '@angular/core';
import { Http, Headers } from '@angular/http';
import { UUID } from 'angular2-uuid';
import 'rxjs/add/operator/toPromise';
import {TodoVo} from './todoVo.component';


@Injectable()
export class TodoService {

  // private api_url = 'api/todos';
  private api_url = 'http://localhost:3000/todos';
  private headers = new Headers({'Content-Type': 'application/json'});


  todos:TodoVo[] = [];

  constructor(private http:Http) {
  }

  addTodo(todoItem:string): Promise<TodoVo> {
    let todo = {
      id: UUID.UUID(),
      desc: todoItem,
      completed: false
    };
    return this.http.post(this.api_url, JSON.stringify(todo), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as TodoVo)
      .catch(this.handleError);
  }

  toggleTodo(todo:TodoVo): Promise<TodoVo>{
    const url = `${this.api_url}/${todo.id}`;
    console.log(url);
    let updateTodo = Object.assign({}, todo, {completed: !todo.completed});
    return this.http.put(url, JSON.stringify(todo), {headers: this.headers})
      .toPromise().then(() => updateTodo)
      .catch(this.handleError);
  }

  deleteTodoByid(id:string):Promise<void>{
    const url = `${this.api_url}/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);

  }

  getTodos():Promise<TodoVo[]>{
    return this.http.get(this.api_url, {headers: this.headers})
      .toPromise()
      .then(res => res.json() as TodoVo[])
      .catch(this.handleError);
  }

  filterTodos(filter:string):Promise<TodoVo[]>{
    switch (filter){
      case 'ACTIVE':
        return this.http.get(`${this.api_url}?completed=false`, {headers: this.headers})
          .toPromise()
          .then(res => res.json() as TodoVo[])
          .catch(this.handleError);
      case 'COMPLETED':
        return this.http
          .get(`${this.api_url}?completed=true`)
          .toPromise()
          .then(res => res.json() as TodoVo[])
          .catch(this.handleError);
      default:
        return this.getTodos();
    }
  }


  private handleError(error:any):Promise<any>{
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}

import { InMemoryDbService } from 'angular-in-memory-web-api';
import { TodoVo } from './todoVo.component';

export class InMemoryTodoDbService implements InMemoryDbService {
  createDb() {
    let todos: TodoVo[] = [
      {id: "f823b191-7799-438d-8d78-fcb1e468fc78", desc: 'Getting up', completed: true},
      {id: "c316a3bf-b053-71f9-18a3-0073c7ee3b76", desc: 'Go to school', completed: false}
    ];
    return {todos};
  }
}

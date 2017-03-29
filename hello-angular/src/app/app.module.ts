import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {LoginComponent} from './login/login.component';
import {TodoModule} from './todo/todo.module'
import {AppComponent} from './app.component';
import {AuthService} from './core/auth.service';
import {routing} from './app.routes';
// import {InMemoryWebApiModule} from 'angular-in-memory-web-api';
// import {InMemoryTodoDbService} from './todo/todo-data';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    // InMemoryWebApiModule.forRoot(InMemoryTodoDbService),
    routing,
    TodoModule
  ],
  providers: [
    {provide: 'auth', useClass: AuthService}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

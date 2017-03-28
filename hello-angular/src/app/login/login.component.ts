import {Component, OnInit, Inject} from "@angular/core";

@Component({
  selector: 'app-login',
  template: `
    <div>
        <form #formRef="ngForm" (ngSubmit)="onSubmit(formRef.value)">
            <fieldset ngModelGroup="login">
              <input 
                  name="username"
                  required 
                  minlength="3" 
                  [(ngModel)]="username" 
                  #usernameRef="ngModel" 
                  type="text"
                  placeholder="请输入用户名">
                  {{usernameRef.errors | json}}
                  <div *ngIf="usernameRef.errors?.required">this is required</div>
                  <div *ngIf="usernameRef.errors?.minlength">should be at least 3 charactors</div>
              <input 
                    name="password"
                    required 
                    [(ngModel)]="password" 
                    #passwordRef="ngModel" 
                    type="password"
                    placeholder="请输入密码">{{passwordRef.valid}}
              <button type="submit">Login</button>
            </fieldset>
        </form>
       
    </div>
  `,
  styles: ['input.ng-invalid{ border:3px solid red;} input.ng-valid{ border:3px solid green;}'],
  providers: []
})
export class LoginComponent implements OnInit {

  constructor(@Inject('auth') private service) {
  }

  username = '';
  password = '';

  ngOnInit() {
  }

  clickMe() {
    console.log("auth result is " + this.service.loginWithCredentials(this.username, this.password))
  }

  onSubmit(formValue) {
    console.log("auth result is " + this.service.loginWithCredentials(formValue.login.username, formValue.login.password));
  }

}

import {NgModule} from "@angular/core";
import {Routes, RouterModule} from '@angular/router';

import {ClientComponent} from './client.component';
import {LoginComponent} from './login/login.component';

const routes:Routes = [
  {
    path: 'client',
    component: ClientComponent
  }, {
    path: 'login',
    component:LoginComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})

export class ClientRoutingModule {
}


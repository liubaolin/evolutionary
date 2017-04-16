import {NgModule} from "@angular/core";
import {Routes, RouterModule} from '@angular/router';

import {ClientComponent} from './client.component';
import {LoginComponent} from './login/login.component';

const routes:Routes = [
  /*{
    path:'',
    redirectTo:'index',
    pathMatch:'full'
  },*/
  {
    path: '',
    component: ClientComponent,
    children:[
      {
        path: 'login',
        component:LoginComponent
      }
    ]
  },
  {
    path:'aboutus',
    loadChildren:'app/client/aboutus/aboutus.module#AmoutUsModule'
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})

export class ClientRoutingModule {
}


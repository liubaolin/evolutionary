import {NgModule} from "@angular/core";
import {Routes, RouterModule} from '@angular/router';
import {AboutUsComponent} from './aboutus.component';
import {IntroduceComponent} from './introduce/introduce.component';

const routes:Routes = [
  {
    path: 'aboutus',
    component:AboutUsComponent,
    children:[
      {
        path: ':introduce',
        component: IntroduceComponent
      }
    ]
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})

export class AboutUsRoutingModule {
}


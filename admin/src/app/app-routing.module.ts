import {NgModule} from "@angular/core";
import {Routes, RouterModule} from '@angular/router';
import {PageNotFoundComponent} from './not-found.component';

const routes:Routes = [
  {
    path: '',
    redirectTo: 'client',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}

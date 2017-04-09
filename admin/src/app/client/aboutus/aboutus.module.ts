import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {IntroduceComponent} from './introduce/introduce.component';
import {AboutUsComponent} from './aboutus.component';
import {AboutUsRoutingModule} from './aboutus-routing.module';

@NgModule({
  imports: [
    CommonModule,
    AboutUsRoutingModule
  ],
  declarations: [
    IntroduceComponent,
    AboutUsComponent
  ]
})
export class AmoutUsModule {
}

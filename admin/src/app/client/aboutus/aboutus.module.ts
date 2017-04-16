import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {IntroduceComponent} from './introduce/introduce.component';
import {AboutUsComponent} from './aboutus.component';
import {AboutUsRoutingModule} from './aboutus-routing.module';
import { NewsCenterComponent } from './news-center/news-center.component';
import { PartnerComponent } from './partner/partner.component';
import { NewsDetailComponent } from './news-center/news-detail/news-detail.component';

@NgModule({
  imports: [
    CommonModule,
    AboutUsRoutingModule
  ],
  declarations: [
    AboutUsComponent,
    IntroduceComponent,
    NewsCenterComponent,
    PartnerComponent,
    NewsDetailComponent
  ]
})
export class AmoutUsModule {
}

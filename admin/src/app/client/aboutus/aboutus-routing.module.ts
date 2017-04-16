import {NgModule} from "@angular/core";
import {Routes, RouterModule} from '@angular/router';
import {AboutUsComponent} from './aboutus.component';
import {IntroduceComponent} from './introduce/introduce.component';
import {NewsCenterComponent} from './news-center/news-center.component';
import {PartnerComponent} from './partner/partner.component';
import {NewsDetailComponent} from './news-center/news-detail/news-detail.component';

const routes:Routes = [
  {
    path: 'aboutus',
    component: AboutUsComponent,
    children: [
      {
        path: 'introduce',
        component: IntroduceComponent
      },
      {
        path: 'newsCenter',
        component: NewsCenterComponent,
        children: [
          {
            path: ':id',
            component: NewsDetailComponent
          }

        ]
      },
      {
        path: 'partner',
        component: PartnerComponent
      },
      {
        path: '',
        redirectTo: 'introduce',
        pathMatch: 'full'
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


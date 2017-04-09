import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';


import {ClientRoutingModule} from './client-routing.module';
import {AmoutUsModule} from './aboutus/aboutus.module';
import {LoginComponent} from './login/login.component';
import {ClientComponent} from './client.component';
import {BingImageService} from './bing-image.service';


@NgModule({
  imports: [
    CommonModule,
    AmoutUsModule,
    ClientRoutingModule
  ],
  declarations: [
    ClientComponent,
    LoginComponent
  ],
  providers: [
    {provide: 'bing', useClass: BingImageService}
  ]
})

export class ClientModule {
}


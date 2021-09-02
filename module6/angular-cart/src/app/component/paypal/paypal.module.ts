import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PaypalRoutingModule } from './paypal-routing.module';
import { PayalShowComponent } from './payal-show/payal-show.component';
import {AppComponent} from '../../app.component';


@NgModule({
  declarations: [PayalShowComponent],
  imports: [
    CommonModule,
    PaypalRoutingModule
  ],
  bootstrap: [PayalShowComponent]
})
export class PaypalModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PaypalRoutingModule } from './paypal-routing.module';
import { PayalShowComponent } from './payal-show/payal-show.component';
import {AppComponent} from '../../app.component';
import {PaypalShowComponent} from './paypal-show/paypal-show.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [PayalShowComponent, PaypalShowComponent],
  imports: [
    CommonModule,
    PaypalRoutingModule,
    FormsModule
  ],
  bootstrap: [PayalShowComponent]
})
export class PaypalModule { }

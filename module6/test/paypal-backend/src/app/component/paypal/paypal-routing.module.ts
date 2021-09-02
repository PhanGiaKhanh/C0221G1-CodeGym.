import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PayalShowComponent} from './payal-show/payal-show.component';
import {PaypalShowComponent} from './paypal-show/paypal-show.component';


const routes: Routes = [
  {
    path: '',
    component: PayalShowComponent
  },
  {
    path: 'paypal',
    component: PaypalShowComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaypalRoutingModule { }

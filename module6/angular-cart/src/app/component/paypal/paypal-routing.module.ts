import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PayalShowComponent} from './payal-show/payal-show.component';


const routes: Routes = [
  {
    path: '',
    component: PayalShowComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaypalRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './component/layout/home/home.component';
import {BenhNhanListComponent} from './component/benhNhan/benh-nhan-list/benh-nhan-list.component';
import {BenhNhanEditComponent} from './component/benhNhan/benh-nhan-edit/benh-nhan-edit.component';


const routes: Routes = [
  {
    path: 'benhNhan',
    component: BenhNhanListComponent
  },
  {
    path: 'benhNhan/edit/:id',
    component: BenhNhanEditComponent
  },
  {
    path: '',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

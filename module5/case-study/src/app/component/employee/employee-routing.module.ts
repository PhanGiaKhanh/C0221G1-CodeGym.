import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from '../customer/customer-list/customer-list.component';
import {CustomerCreateComponent} from '../customer/customer-create/customer-create.component';
import {CustomerEditComponent} from '../customer/customer-edit/customer-edit.component';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {EmployeeEditComponent} from './employee-edit/employee-edit.component';
import {EmployeeCreateComponent} from './employee-create/employee-create.component';


const routes: Routes = [
  {
    path: '',
    component: EmployeeListComponent
  },
  {
    path: 'create',
    component: EmployeeCreateComponent
  },
  // {
  //   path: 'edit/:id',
  //   component: EmployeeEditComponent
  // },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { }

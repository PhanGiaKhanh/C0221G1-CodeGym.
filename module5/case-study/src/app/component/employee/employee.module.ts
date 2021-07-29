import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2OrderModule} from 'ng2-order-pipe';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';


@NgModule({
  declarations: [EmployeeEditComponent, EmployeeCreateComponent],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    // page/sort/search
    NgxPaginationModule,
    Ng2OrderModule,
    Ng2SearchPipeModule,
    ReactiveFormsModule,
    MatFormFieldModule,
  ]
})
export class EmployeeModule { }

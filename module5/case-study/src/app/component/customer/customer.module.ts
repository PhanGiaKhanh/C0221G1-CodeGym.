import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CustomerRoutingModule} from './customer-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {CustomerCreateComponent} from './customer-create/customer-create.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {Ng2OrderModule} from 'ng2-order-pipe';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';

@NgModule({
  declarations: [
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerEditComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    // page/sort/search
    NgxPaginationModule,
    Ng2OrderModule,
    Ng2SearchPipeModule,

    MatInputModule,
    MatDatepickerModule,
    MatTableModule,
    MatIconModule,

  ]
})
export class CustomerModule {
}

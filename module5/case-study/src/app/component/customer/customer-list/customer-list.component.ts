import {Component, OnInit} from '@angular/core';
import {Customer} from '../../../model/customer/customer';
import {CustomerService} from '../../../service/customer.service';
import {DeleteModalComponent} from '../../../delete-modal/delete-modal/delete-modal.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  page = 1;
  nameSearch = '';
  emailSearch = '';
  key = ''; // set default
  reverse = false;
  filter = '';
  nameDelete: string;
  idDelete: number;
  public customer!: Customer;
  index: number;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  constructor(private customerService: CustomerService,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.getAll();
  }


  getAll() {
    this.customerService.getAll().subscribe(customers => {
      this.customers = customers;
    });
  }

  search() {
    console.log(this.nameSearch);
    this.customerService.search(this.nameSearch, this.emailSearch).subscribe(c => {
      this.customers = c;
      this.page = 1;
    });
  }

  sendIdDelete(id: number) {
    this.idDelete = id;
    this.customerService.findById(id).subscribe(c => {
      this.customer = c;
      this.nameDelete = c.name;
    });
  }

  deleteCustomer() {
    console.log(this.idDelete);
    this.customerService.delete(this.idDelete).subscribe(() => {
      this.getAll();
    });
  }

  removeDialog(customerObj: Customer) {
    const deleteModal = this.dialog.open(DeleteModalComponent, {
      data: {
        title: 'Hello Nam',
        message: 'Are you sure, you want to remove an customer: ' + customerObj.name
      }
    });
    deleteModal.afterClosed().subscribe(result => {
      if (result === true) {
        this.customerService.delete(customerObj.id).subscribe(() => {
          this.getAll();
        });
      }
    });
  }
}

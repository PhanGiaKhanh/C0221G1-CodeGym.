import {Component, OnInit} from '@angular/core';
import {Customer} from '../../../model/customer/customer';
import {CustomerService} from '../../../service/customer.service';
import {FormControl, FormGroup} from '@angular/forms';

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
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  constructor(private customerService: CustomerService) {
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
}

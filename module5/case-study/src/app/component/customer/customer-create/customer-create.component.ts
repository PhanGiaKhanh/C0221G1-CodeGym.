import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer.service';
import {CustomerType} from '../../../model/customer/customer-type';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss']
})
export class CustomerCreateComponent implements OnInit {
  createForm = new FormGroup({
    // id: new FormControl('', [Validators.required, Validators.min(0)]),
    code: new FormControl('', [Validators.required, Validators.pattern(/^KH-[\\d]{4}$/)]),
    typeCustomer: new FormControl('', Validators.required),
    name: new FormControl('', [Validators.required, Validators.minLength(5)]),
    birthday: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.pattern(/\\d{9}/)]),
    phone: new FormControl('', [Validators.required, Validators.pattern(/(090)\\d{7}/)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required, Validators.minLength(5)]),
  });
  // createForm!: FormGroup;
  customerTypes: CustomerType[];
  constructor(private cs: CustomerService,
              private fb: FormBuilder) {
    // this.initForm();
  }

  ngOnInit(): void {
    this.getCustomerTypes();
  }
  getCustomerTypes(){
    this.cs.getCustomerTypes().subscribe(ct => {
      this.customerTypes = ct;
    });
  }

  // initForm() {
  //   this.createForm = this.fb.group({
  //     code: ['', [Validators.required, Validators.pattern('^KH-[\\d]{4}$')]],
  //     name: ['', [Validators.required]],
  //     gender: ['', [Validators.required]],
  //     idCard: ['', [Validators.required, Validators.pattern('^([0-9]{9}|[0-9]{12})$')]],
  //     phone: ['', [Validators.required, Validators.pattern('^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$')]],
  //     customerType: ['', [Validators.required]],
  //     birthday: ['', [Validators.required, Validators.pattern('^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$')]],
  //     email: ['', [Validators.required, Validators.email]],
  //     address: ['', [Validators.required, Validators.minLength(5)]]
  //
  //   });
  // }

  submit() {
    const customer = this.createForm.value;
    this.cs.save(customer).subscribe(() => {
      this.createForm.reset();
      alert('Tạo thành công');
    }, e => {
      alert('Thất bại');
    });
  }
}

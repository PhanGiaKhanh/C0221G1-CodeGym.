import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../../model/customer/customer-type';
import {CustomerService} from '../../../service/customer.service';
import {Customer} from '../../../model/customer/customer';
import {ActivatedRoute, ParamMap} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  validateMsg = {
    code: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'Pattern (KH-XXXX)'},
    ],
    customerType: [
      {type1: 'required', msg1: 'Not empty'},
    ],
    name: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'minLength', msg1: 'Min length 5'},
    ],
    birthday: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'This is not date'},
    ],
    idCard: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'Must 9 numbers'},
    ],
    phone: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'Pattern (090|091|84+90|84+91)XXXXXX'},
    ],
    email: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'Pattern email'},
    ],
    address: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'Pattern address'},
    ],
    gender: [
      {type1: 'required', msg1: 'Not empty'},
    ],
  };

  editForm!: FormGroup;
  customerTypes: CustomerType[];
  customer!: Customer;
  index: number;
  constructor(private  cs: CustomerService,
              private fb: FormBuilder,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.index = +paramMap.get('id');
      this.getCustomer(this.index);
    });
  }

  ngOnInit(): void {
    this.getCustomerTypes();
  }

  getCustomerTypes() {
    this.cs.getCustomerTypes().subscribe(ct => {
      this.customerTypes = ct;
    });
  }

  getCustomer(id: number) {
    return this.cs.findById(id).subscribe(customer => {
      this.customer = customer;
      console.log(this.customer.gender);
      console.log(this.customer.customerType);
      this.editForm = this.fb.group({
        code: [customer.code, [Validators.required, Validators.pattern(/^KH-[0-9]{4}$/)]],
        name: [customer.name, [Validators.required, Validators.minLength(5)]],
        gender: [customer.gender, [Validators.required]],
        idCard: [customer.idCard, [Validators.required, Validators.pattern(/^([0-9]{9}|[0-9]{12})$/)]],
        phone: [customer.phone, [Validators.required, Validators.pattern(/^(090|091|(\(84\)\+90)|(\(84\)\+91))[0-9]{7}$/)]],
        customerType: [customer.customerType, [Validators.required]],
        birthday: [customer.birthday, [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]],
        email: [customer.email, [Validators.required, Validators.email]],
        address: [customer.address, [Validators.required, Validators.minLength(5)]]
      });
    });
  }

  getValidate(attribute: string, valid): boolean {
    return this.editForm.get(attribute)?.hasError(valid.type1) &&
      (this.editForm.get(attribute)?.touched ||
        this.editForm.get(attribute)?.dirty);
  }

  update(index: number) {
    const customer = this.editForm.value;
    this.cs.update(index, customer).subscribe(() => {
      this.editForm.reset();
      alert('Tạo thành công');
    }, e => {
      alert('Thất bại');
    });
  }
}

import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../service/customer.service';
import {CustomerType} from '../../../model/customer/customer-type';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
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

  createForm!: FormGroup;
  customerTypes: CustomerType[];

  constructor(private  cs: CustomerService,
              private fb: FormBuilder) {
    this.initForm();
  }

  ngOnInit(): void {
    this.getCustomerTypes();
  }

  getCustomerTypes() {
    this.cs.getCustomerTypes().subscribe(ct => {
      this.customerTypes = ct;
    });
  }

  getValidate(attribute: string, valid): boolean {
    return this.createForm.get(attribute)?.hasError(valid.type1) &&
      (this.createForm.get(attribute)?.touched ||
        this.createForm.get(attribute)?.dirty);
  }

  initForm() {
    this.createForm = this.fb.group({
      code: ['', [Validators.required, Validators.pattern(/^KH-[0-9]{4}$/)]],
      name: ['', [Validators.required, Validators.minLength(5)]],
      gender: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern(/^([0-9]{9}|[0-9]{12})$/)]],
      phone: ['', [Validators.required, Validators.pattern(/^(090|091|(\(84\)\+90)|(\(84\)\+91))[0-9]{7}$/)]],
      customerType: ['', [Validators.required]],
      birthday: ['', [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required, Validators.minLength(5)]]
    });
  }

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

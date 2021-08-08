import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {Product} from '../../../model/product';
import {ProductService} from '../../../service/product.service';
import {ProductType} from '../../../model/product-type';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  validateMsg = {
    name: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'minLength', msg1: 'Min length 5'},
    ],
    price: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'minLength', msg1: 'Price > 0 '},
    ],
    date: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'This is not date'},
    ],
    productType: [
      {type1: 'required', msg1: 'Not empty'},
    ]
  };
  createForm = this.fb.group({
    name: ['', [Validators.required, Validators.minLength(5)]],
    price: ['', [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
    date: ['', [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]],
    productType: ['', [Validators.required]]
  });
  productTypes!: ProductType[];

  constructor(private fb: FormBuilder,
              private productService: ProductService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getProductTypes();
  }

  getProductTypes() {
    this.productService.getProductType().subscribe(list => {
      this.productTypes = list;
      console.log(list);
    });
  }

  getValidate(attribute: string, valid): boolean {
    return this.createForm.get(attribute)?.hasError(valid.type1) &&
      (this.createForm.get(attribute)?.touched ||
        this.createForm.get(attribute)?.dirty);
  }

  submit() {
    const product = this.createForm.value;
    this.productService.save(product).subscribe(() => {
      this.createForm.reset();
      alert('Tạo thành công');
      this.router.navigateByUrl('product');
    }, e => {
      alert('Thất bại');
    });
  }
}

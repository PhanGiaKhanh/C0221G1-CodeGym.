import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {ProductType} from '../../../model/product-type';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Product} from '../../../model/product';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
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
  editForm = this.fb.group({
    id: [''],
    name: ['', [Validators.required, Validators.minLength(5)]],
    price: ['', [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
    date: ['', [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]],
    productType: ['', [Validators.required]]
  });
  productTypes!: ProductType[];
  private idEdit: number;
  product!: Product;

  constructor(private fb: FormBuilder,
              private ps: ProductService,
              private activatedRoute: ActivatedRoute) {
    activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.idEdit = +param.get('id');
      ps.findById(this.idEdit).subscribe(p => {
        this.product = p;
        this.editForm.patchValue(p);
      });
    });
  }

  ngOnInit(): void {
    this.getProductTypes();
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  getProductTypes() {
    this.ps.getProductType().subscribe(list => {
      this.productTypes = list;
    });
  }

  getValidate(attribute: string, valid): boolean {
    return this.editForm.get(attribute)?.hasError(valid.type1) &&
      (this.editForm.get(attribute)?.touched ||
        this.editForm.get(attribute)?.dirty);
  }

  submit() {
    const p = this.editForm.value;
    console.log(p);
    this.ps.update(p).subscribe(() => {
      alert('Tạo thành công');
    }, e => {
      alert('Thất bại');
    });
  }
}

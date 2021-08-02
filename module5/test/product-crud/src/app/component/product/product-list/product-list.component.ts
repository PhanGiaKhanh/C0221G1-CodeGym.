import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Product} from '../../../model/product';
import Swal from 'sweetalert2';
import {ProductType} from '../../../model/product-type';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  // idDel: number;
  // productDel!: Product;
  products!: Product[];
  page = 1;
  key = '';
  reverse = false;
  searchName = '';
  searchDate = '';
  searchProductType = '';
  productTypes: ProductType[];
  date1 = '';
  date2 = '';

  constructor(private ps: ProductService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getAll();
    this.getProductTypes();
  }

  getProductTypes() {
    this.ps.getProductType().subscribe(list => {
      this.productTypes = list;
    });
  }

  getAll() {
    this.ps.getAll().subscribe(products => {
      this.products = products;
    });
  }

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  search() {
    this.ps.search(this.searchName, this.searchDate, this.searchProductType, this.date1, this.date2).subscribe(list => {
      this.products = list;
      this.page = 1;
    });
  }

  removeDialog(p: Product) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: 'Do you want to ' + p.name,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.ps.delete(p.id).subscribe(() => {
          this.getAll();
        });
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          'Your imaginary file is safe :)',
          'error'
        );
      }
    });
  }

  resetDate() {
    this.date1 = '';
    this.date2 = '';
  }
}

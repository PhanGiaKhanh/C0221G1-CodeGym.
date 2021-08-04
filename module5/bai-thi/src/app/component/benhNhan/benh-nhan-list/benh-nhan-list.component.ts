import { Component, OnInit } from '@angular/core';

import Swal from 'sweetalert2';
import {BenhNhan} from '../../../model/benh-nhan';
import {BacSi} from '../../../model/bac-si';
import {BenhAn} from '../../../model/benh-an';
import {BenhNhanService} from '../../../service/benh-nhan.service';

@Component({
  selector: 'app-benh-nhan-list',
  templateUrl: './benh-nhan-list.component.html',
  styleUrls: ['./benh-nhan-list.component.css']
})
export class BenhNhanListComponent implements OnInit {
  benhNhanList!: BenhNhan[];

  constructor( private benhNhanService: BenhNhanService) {
  }

  ngOnInit(): void {
    this.getBenhNhanList();
    console.log(this.benhNhanList);
  }

  getBenhNhanList(){
    this.benhNhanService.getAll().subscribe( list => {
      this.benhNhanList = list;
    });
  }

  removeDialog(benhNhan: BenhNhan) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: 'Bạn muốn xóa thông tin bệnh án ' + benhNhan.maBenhAn + ' hay không? ',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Có',
      cancelButtonText: 'Không',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.benhNhanService.delete(benhNhan.id).subscribe(() => {
          this.getBenhNhanList();
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
}

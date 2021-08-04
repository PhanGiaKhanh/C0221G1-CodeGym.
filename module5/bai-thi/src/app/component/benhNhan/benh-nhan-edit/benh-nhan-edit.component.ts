import {Component, OnInit} from '@angular/core';
import {BenhNhanService} from '../../../service/benh-nhan.service';
import {BenhAn} from '../../../model/benh-an';
import {BacSi} from '../../../model/bac-si';
import {AbstractControl, FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {BenhNhan} from '../../../model/benh-nhan';

@Component({
  selector: 'app-benh-nhan-edit',
  templateUrl: './benh-nhan-edit.component.html',
  styleUrls: ['./benh-nhan-edit.component.css']
})
export class BenhNhanEditComponent implements OnInit {
  validateMsg = {
    ten: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'tên không chứa số'},
    ],
    ngayNhapVien: [
      {type1: 'required', msg1: 'Not empty'}
    ],
    ngayRaVien: [
      {type1: 'required', msg1: 'Not empty'}
    ],
    bacSi: [
      {type1: 'required', msg1: 'Not empty'},
    ],
    lyDoRaVien: [
      {type1: 'required', msg1: 'Not empty'},
    ],
    benhAn: [
      {type1: 'required', msg1: 'Not empty'},
    ]
  };
  editForm = this.fb.group({
    id: [''],
    maBenhAn: ['', [Validators.required]],
    maBenhNhan: ['', [Validators.required]],
    ten: ['', [Validators.required, Validators.pattern('[(A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴa-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ)\\p{P}]+(?:\\s[(A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴa-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ)\\p{P}]+)+')]],
    ngayNhapVien: ['', [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]],
    ngayRaVien: ['', [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]],
    lyDoRaVien: ['', [Validators.required]],
    benhAn: ['', [Validators.required]],
    bacSi: ['', [Validators.required]],
  }, this.validDate);

  benhAnList!: BenhAn[];
  bacSiList!: BacSi[];
  idEdit: number;
  benhNhan!: BenhNhan;

  constructor(private  benhNhanService: BenhNhanService,
              private  fb: FormBuilder,
              private  activatedRoute: ActivatedRoute,
              private  router: Router) {
    activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.idEdit = +param.get('id');
      benhNhanService.findById(this.idEdit).subscribe(p => {
        this.benhNhan = p;
        this.editForm.patchValue(p);
      });
    });
  }

  ngOnInit(): void {
    this.getBenhAnList();
    this.getBacSiList();
  }

  getBenhAnList() {
    this.benhNhanService.getBenhAn().subscribe(list1 => {
      this.benhAnList = list1;
    });
  }

  getBacSiList() {
    this.benhNhanService.getBacSi().subscribe(list2 => {
      this.bacSiList = list2;
    });
  }

  getValidate(attribute: string, valid): boolean {
    return this.editForm.get(attribute)?.hasError(valid.type1) &&
      (this.editForm.get(attribute)?.touched ||
        this.editForm.get(attribute)?.dirty);
  }


  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  submit() {
    const p = this.editForm.value;
    console.log(p);
    this.benhNhanService.update(p).subscribe(() => {
      alert('Tạo thành công');
      this.router.navigateByUrl('benhNhan');
    }, e => {
      alert('Thất bại');
    });
  }

  validDate(control: AbstractControl) {
    const v = control.value;
    const start = new Date(v.ngayNhapVien);
    const end = new Date(v.ngayRaVien);
    if (end.getTime() - start.getTime() < 0) {
      return {validDate: true};
    }
    return null;
  }
}

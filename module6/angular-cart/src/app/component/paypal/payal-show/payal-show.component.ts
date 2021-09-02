import {Component, OnInit, Pipe, PipeTransform} from '@angular/core';
import {MedicineCart} from '../../../model/medicine-cart';
import {HttpClient} from '@angular/common/http';
import {renderConstantPool} from '@angular/compiler-cli/ngcc/src/rendering/renderer';

// @Pipe ({
//   name : 'VND'
// })

@Component({
  selector: 'app-payal-show',
  templateUrl: './payal-show.component.html',
  styleUrls: ['./payal-show.component.css']
})
export class PayalShowComponent implements OnInit {
  list = [
    {
      img: 'https://image.pharmacity.vn/live/uploads/2019/04/P00066_1_l-300x300.jpg',
      info: 'Dầu gió xanh Thiên Thảo (Chai12ml)',
      unit: 19500,
      amount: 10,
      price: 195000
    },
    {
      img: 'https://image.pharmacity.vn/live/uploads/2019/04/P00779_1_l.jpg',
      info: 'Fugacar Mebendazole (500mg)',
      unit: 19000,
      amount: 5,
      price: 95000
    },
    {
      img: 'https://image.pharmacity.vn/live/uploads/2021/07/P20426_1_l-300x300.jpg',
      info: 'Tăm bông kháng khuẩn đầu xoán Sakura(Lọ 200 que giấy)',
      unit: 44000,
      amount: 20,
      price: 880000
    }
  ];
  ob1 = {
    img: 'https://image.pharmacity.vn/live/uploads/2021/07/P20426_1_l-300x300.jpg',
    info: 'Tăm bông kháng khuẩn đầu xoán Sakura(Lọ 200 que giấy)',
    unit: 44000,
    amount: 20,
    price: 880000
  };
  medicines: MedicineCart[];
  medicine!: MedicineCart;
  moneyTotal = 0;
  moneyPayPal = 0;
  medicineTotal = 0;



  constructor() {
  }

  ngOnInit(): void {
    this.getMedicineList();
    this.getTotal();
    // this.http.get(this.API_URL).subscribe( data => {
    //   console.log(JSON.stringify(data));
    // });
    // // console.log(JSON.stringify(this.API_URL));
    // // fetch(this.API_URL).then((reponse) => console.log(reponse[5]));
    // console.log("Test success");
  }

  getMedicineList() {
    localStorage.setItem('medicineList', JSON.stringify(this.list));

    this.medicines = JSON.parse(localStorage.getItem('medicineList'));
  }


  //#region ADD + SUB + DEL + UPDATE
  medicineSub(i: number) {
    if (this.medicines[i].amount > 0) {
      this.medicines[i].amount--;
    }
    this.medicines[i].price = this.medicines[i].unit * this.medicines[i].amount;
    localStorage.setItem('medicines', JSON.stringify(this.medicine));
  }

// thêm tổng số lượng thuốc thay cho 20
  medicineAdd(i: number) {
    if (this.medicines[i].amount < 20) {
      this.medicines[i].amount++;
    }
    this.medicines[i].price = this.medicines[i].unit * this.medicines[i].amount;
    localStorage.setItem('medicines', JSON.stringify(this.medicine));
  }


  delMedicine(i: number) {
    this.medicines.splice(i, 1);
    localStorage.setItem('medicineList', JSON.stringify(this.medicines));
  }

  getTotal() {
    for (let i = 0; i < this.medicines.length; i++) {
      this.moneyTotal += this.medicines[i].price;
      this.medicineTotal += this.medicines[i].amount;
      if (this.medicines[i].unit === 0) {

      }
    }
    this.moneyPayPal = this.moneyTotal / 23000;
  }

  update() {
    this.medicineTotal = 0;
    this.moneyTotal = 0;
    this.moneyPayPal = 0;
    this.getTotal();
    localStorage.setItem('medicineList', JSON.stringify(this.medicines));
  }

  // #endregion

  //#region CONVERT MONEY

  // #endregion
}

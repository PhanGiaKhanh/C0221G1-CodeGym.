import {AfterViewChecked, Component, OnInit, Pipe} from '@angular/core';
import {MedicineCart} from '../../../model/medicine-cart';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Currency} from '../../../model/currency';
import {CartService} from '../../../service/cart.service';

//#region USD100 >> 100 USD

import {registerLocaleData} from '@angular/common';
import localeFr from '@angular/common/locales/fr';

registerLocaleData(localeFr, 'fr');

// #endregion

declare let paypal: any;

@Component({
  selector: 'app-payal-show',
  templateUrl: './payal-show.component.html',
  styleUrls: ['./payal-show.component.css']
})
export class PayalShowComponent implements OnInit, AfterViewChecked {
  list = [
    {
      img: 'https://image.pharmacity.vn/live/uploads/2019/04/P00066_1_l-300x300.jpg',
      info: 'Dầu gió xanh Thiên Thảo (Chai12ml)',
      unit: 19500,
      amount: 10,
      price: 195000,
      maxAmount: 11,
    },
    {
      img: 'https://image.pharmacity.vn/live/uploads/2019/04/P00779_1_l.jpg',
      info: 'Fugacar Mebendazole (500mg)',
      unit: 19000,
      amount: 5,
      price: 95000,
      maxAmount: 20,
    },
    {
      img: 'https://image.pharmacity.vn/live/uploads/2021/07/P20426_1_l-300x300.jpg',
      info: 'Tăm bông kháng khuẩn đầu xoán Sakura(Lọ 200 que giấy)',
      unit: 44000,
      amount: 1,
      price: 44000,
      maxAmount: 3,
    },
    {
      img: 'https://image.pharmacity.vn/live/uploads/2021/07/P20426_1_l-300x300.jpg',
      info: 'Tăm bông kháng khuẩn đầu xoán Sakura(Lọ 200 que giấy)',
      unit: 44000,
      amount: 3,
      price: 132000,
      maxAmount: 20,
    },
    {
      img: 'https://image.pharmacity.vn/live/uploads/2021/07/P20426_1_l-300x300.jpg',
      info: 'Tăm bông kháng khuẩn đầu xoán Sakura(Lọ 200 que giấy)',
      unit: 44000,
      amount: 2,
      price: 88000,
      maxAmount: 20,
    }
  ];
  medicines: MedicineCart[];
  medicine!: MedicineCart;
  moneyTotal = 0;
  moneyPayPal = 0;
  medicineTotal = 0;
  currency!: Currency;
  currencyDateNow = '';
  currencyMoney = 0;
//#region PAYPAL
  finalAccount: number = 1;
  paypalLoad: boolean = true;

  addScript: boolean = false;
  paypalConfig = {
    env: 'sandbox',
    client: {
      sandbox: 'AbnnpqkZWFt3p_vsAq9MTYGktX4-6iq1LQVNQlSCVSFPxZ-wNFmL65aE0JGqu4E8a1nzUDX8XkP2amk6',
      production: 'XXXxxxXXX'
    },
    style: {
      label: 'pay',   // paypal | checkout | pay
      size: 'responsive',    // small | medium | large | responsive
      shape: 'pill',     // pill | rect
      color: 'gold',      // gold | blue | silver | black
      tagline: 'true'
    },
    commit: true,
    payment: (data, actions) => {
      return actions.payment.create({
        payment: {
          transactions: [
            {amount: {total: this.finalAccount, currency: 'USD'}}
          ]
        }
      });
    },
    onAuthorize: (data, actions) => {
      return actions.payment.execute().then((payment) => {
        //Do something when payment is successful.
        alert('ok 2');
      });
    }
  };

//   #endregion
  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {
    this.getMedicineList();
    this.getTotal();
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

//thêm tổng số lượng thuốc thay cho 20
  medicineAdd(i: number) {
    if (this.medicines[i].amount < this.medicines[i].maxAmount) {
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
    console.log(this.medicineTotal);
    for (let i = 0; i < this.medicines.length; i++) {
      this.moneyTotal += this.medicines[i].price;
      this.medicineTotal += this.medicines[i].amount;
      console.log(this.medicineTotal);
      if (this.medicines[i].amount === 0) {
        this.delMedicine(i);
      }
    }
    this.convertUsdCurrency(this.moneyTotal);
  }

  update() {
    this.medicineTotal = 0;
    this.moneyTotal = 0;
    this.moneyPayPal = 0;
    this.getTotal();
    localStorage.setItem('medicineList', JSON.stringify(this.medicines));
  }

  // #endregion

  //#region CONVERT MONEY get MONEY + Date now currency + Currency
  convertUsdCurrency(VND: number) {
    this.cartService.convertUsdCurrency().subscribe(data => {
      this.currency = data;
      const vnd = this.currency.rates['VND'];
      const usd = this.currency.rates['USD'];
      this.currencyDateNow = this.currency.date;
      this.currencyMoney = vnd / usd;
      this.moneyPayPal = usd * VND / vnd;
    });
  }

  // #endregion

  //#region Paypal
  ngAfterViewChecked(): void {
    if (!this.addScript) {
      this.addPaypalScript().then(() => {
        paypal.Button.render(this.paypalConfig, '#myPaypalButton');
        this.paypalLoad = false;
        // alert('ok successful');
      });
    }
  }

  private addPaypalScript() {
    this.addScript = true;
    return new Promise((resolve, rejects) => {
      let scriptTagElement = document.createElement('script');
      scriptTagElement.src = 'https://www.paypalobjects.com/api/checkout.js';
      scriptTagElement.onload = resolve;
      document.body.appendChild(scriptTagElement);
    });
  }
  // #endregion
}

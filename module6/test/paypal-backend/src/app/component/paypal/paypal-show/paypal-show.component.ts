import {AfterViewChecked, Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {HttpClient, HttpHeaders} from '@angular/common/http';

declare let paypal: any;

@Component({
  selector: 'app-paypal-show',
  templateUrl: './paypal-show.component.html',
  styleUrls: ['./paypal-show.component.css']
})
export class PaypalShowComponent implements OnInit, AfterViewChecked {
  finalAccount: number = 1;
  paypalLoad: boolean = true;

  addScript: boolean = false;
  paypalConfig = {
    env: 'sandbox',
    client: {
      sandbox: 'AbnnpqkZWFt3p_vsAq9MTYGktX4-6iq1LQVNQlSCVSFPxZ-wNFmL65aE0JGqu4E8a1nzUDX8XkP2amk6',
      production: '<your-production-key here>'
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
        alert("ok 2")
      });
    }
  };

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
  }

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

  onSubmit(contactForm: NgForm) {
    if (contactForm.valid) {
      const email = contactForm.value;
      const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      this.http.post('https://formspree.io/asdlf7asdf',
        { name: email.name, replyto: email.email, message: email.messages },
        { 'headers': headers }).subscribe(
        response => {
          console.log(response);
        }
      );
    }
  }
}

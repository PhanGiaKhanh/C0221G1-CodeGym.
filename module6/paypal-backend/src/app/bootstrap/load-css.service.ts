import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoadCssService {
  constructor() { }
  loadCss(src) {
    const css = document.createElement('link');
    css.rel = 'stylesheet';
    document.getElementsByTagName('head')[0].appendChild(css);
    css.href = src;
  }
  loadScript(src) {
    const script = document.createElement('script');
    script.type = 'text/javascript';
    document.getElementsByTagName('body')[0].appendChild(script);
    script.src = src;
  }
  validateMsg(){
    return {
      code: [
        {type1: 'required' , msg1: 'Not empty' },
        {type1: 'pattern' , msg1: 'Pattern (KH-XXXX)' },
      ],
      customerType: [
        {type1: 'required' , msg1: 'Not empty' },
      ],
      name: [
        {type1: 'required' , msg1: 'Not empty' },
        {type1: 'minLength' , msg1: 'Min length 5' },
      ],
      birthday: [
        {type1: 'required' , msg1: 'Not empty' },
        {type1: 'pattern' , msg1: 'This is not date' },
      ],
      idCard: [
        {type1: 'required' , msg1: 'Not empty' },
        {type1: 'pattern' , msg1: 'Must 9 numbers' },
      ],
      phone: [
        {type1: 'required' , msg1: 'Not empty' },
        {type1: 'pattern' , msg1: 'Pattern (090|091|84+90|84+91)XXXXXX' },
      ],
      email: [
        {type1: 'required' , msg1: 'Not empty' },
        {type1: 'pattern' , msg1: 'Pattern email' },
      ],
      address: [
        {type1: 'required' , msg1: 'Not empty' },
        {type1: 'pattern' , msg1: 'Pattern address' },
      ]
    };
  }
}

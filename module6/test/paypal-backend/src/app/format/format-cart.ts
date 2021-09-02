import {Pipe, PipeTransform} from '@angular/core';
@Pipe ({
  name : 'VND'
})
export class FormatCartPige implements PipeTransform {
  transform(val : number) : number {
    return Math.sqrt(val);
  }
}

import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-rating-bar-component',
  templateUrl: './rating-bar-component.component.html',
  styleUrls: ['./rating-car-component.component.css']
})
export class RatingBarComponentComponent implements OnInit {
  arrNumber10 = [0,1,2,3,4,5,6,7,8,9,10];
  choose = 1;
  constructor() { }

  ngOnInit(): void {
  }
  getChoose(num: number){
    this.choose = num + 1;
  }
}

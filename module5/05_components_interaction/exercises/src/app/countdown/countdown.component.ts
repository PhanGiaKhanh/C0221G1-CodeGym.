import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Subscription, timer} from "rxjs";

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.css']
})
export class CountdownComponent implements OnInit, OnDestroy {
  message = '';
  remainingTime: number;
  @Input()
  seconds: string;
  @Output()
  finish = new EventEmitter<string[]>();
  private intervalId = 0;
  constructor() {
  }

  ngOnInit(): void {
    this.reset();
  }

  ngOnDestroy() {
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }

  start() {
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = Number(this.seconds);
    }
  }

  stop() {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }

  reset() {
    this.clearTimer();
    this.remainingTime = Number(this.seconds);
    this.message = `Click start button to start the Countdown`;
    this.finish.emit([this.remainingTime + '', this.message ]);
  }
  private countDown() {
    this.clearTimer();
    this.intervalId = setInterval(() => {
      this.finish.emit([this.remainingTime + '', this.message ]);
      this.remainingTime--;
      this.message = `Time: ${this.remainingTime} seconds and counting`;
    }, 400);}
  // private countDown() {
  //     this.clearTimer();
  //     this.intervalId = window.setInterval(() => {
  //       this.remainingTime++;
  //       if (this.remainingTime === 0) {
  //         this.message = 'Blast off!';
  //         this.clearTimer();
  //         this.finish.emit(true);
  //       } else {
  //         this.message = `T-${this.remainingTime} seconds and counting`;
  //       }
  //     }, 400);
  // }
}

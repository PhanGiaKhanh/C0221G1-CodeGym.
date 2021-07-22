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
  seconds = 0;
  @Output()
  finish = new EventEmitter<boolean>();
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
    // if (this.remainingTime <= 0) {
    //   this.remainingTime = this.seconds;
    // }
  }

  stop() {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }

  reset() {
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = `Click start button to start the Countdown`;
  }
  private countDown() {
    this.clearTimer();
    this.intervalId = setInterval(() => {
      this.remainingTime++;
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

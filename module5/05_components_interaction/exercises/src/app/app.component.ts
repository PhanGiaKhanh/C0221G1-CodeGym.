import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl:  './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'exercises';
  time = '';
  count = '';
  msg = '';

  display(e: string[]) {
    this.count = e[0];
    this.msg = e[1];
  }
}

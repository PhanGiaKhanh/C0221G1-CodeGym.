import {Component, OnInit} from '@angular/core';
import {LoadCssService} from './bootstrap/load-css.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'jquery-test';

  constructor(private loadCss: LoadCssService) {
    loadCss.loadScript('https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js');
    loadCss.loadScript('https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js');
    loadCss.loadScript('assets/sideBar.js');
  }
}

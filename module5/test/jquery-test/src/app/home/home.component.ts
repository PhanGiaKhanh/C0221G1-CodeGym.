import { Component, OnInit } from '@angular/core';
import {LoadCssService} from '../bootstrap/load-css.service';

@Component({
    selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'
  ]
})
export class HomeComponent implements OnInit {

  constructor(private loadCss: LoadCssService) {
    loadCss.loadScript('https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js');
    loadCss.loadScript('https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js');
    loadCss.loadScript('assets/sideBar.js');
  }

  ngOnInit(): void {
  }

}

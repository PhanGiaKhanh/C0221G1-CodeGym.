import { Component, OnInit } from '@angular/core';
import {DictionaryService, IWord} from '../dictionary.service';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  listWord: IWord[] = [];
  constructor(
    private dictionaryService: DictionaryService
  ) { }

  ngOnInit() {
    this.listWord = this.dictionaryService.getAll();
  }

}

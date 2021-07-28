import { Component, OnInit } from '@angular/core';
import {DictionaryService, IWord} from '../dictionary.service';

@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {
  word: IWord;
  constructor(private dictionaryService: DictionaryService) { }
  ngOnInit(): void {
  }

}

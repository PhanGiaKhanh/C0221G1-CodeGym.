import { Injectable } from '@angular/core';
export interface IWord {
  key: string;
  meaning: string;
}
@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  private words: IWord[] = [
    {
      key: 'Hello',
      meaning: 'Chào Bạn'
    }, {
      key: 'Where are you',
      meaning: 'Bạn ở đâu ?'
    }, {
      key: 'Thank you',
      meaning: 'Cảm ơn'
    }, {
      key: 'Good night',
      meaning: 'Chúc ngủ ngon'
    }, {
      key: 'Exercises',
      meaning: 'Bài tập'
    }
  ];
  constructor() { }

  search(word: string): string {
    if (!word) {
      return '';
    }
    const w = this.words.find(item => item.key === word);
    if (w) {
      return w.meaning;
    }
    return 'Not found';
  }

  getAll(): IWord[] {
    return this.words;
  }
}

import {Injectable} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {DeleteComponent} from '../component/delete/delete.component';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private dialog: MatDialog) {
  }

  openConfirmDialog(msg) {
    // this.dialog.open(MatConfirmDialogComponent, {
    return this.dialog.open(DeleteComponent, {
      width: '390px',
      panelClass: 'confirm-dialog-container',
      disableClose: true,
      data: {
        message: msg,
      }
    });
  }
}

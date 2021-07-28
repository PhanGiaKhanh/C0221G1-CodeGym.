import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-delete-modal',
  templateUrl: './delete-modal.component.html',
  styleUrls: ['./delete-modal.component.scss']
})
export class DeleteModalComponent implements OnInit {
  title: string;
  message: string;

  constructor(public dialogRef: MatDialogRef<DeleteModalComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit() {
  }
}

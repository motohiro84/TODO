import { Component, Output, EventEmitter  } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent {
  @Output() onClose = new EventEmitter<boolean>();

  constructor(
    public dialogRef: MatDialogRef<ConfirmationComponent>
  ) { }
  
  closeDialog(isConfirmed: boolean): void {
    this.onClose.emit(isConfirmed);
    this.closeModal();
  }

  // ダイアログを閉じる
  closeModal() {
    this.dialogRef.close();
  }

}
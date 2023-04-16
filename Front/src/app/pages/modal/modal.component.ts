import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent {
  @Input() showModal: boolean;
  @Output() closeModal = new EventEmitter<boolean>();
  @Output() confirmAction = new EventEmitter<boolean>();

  fermerModal() {
    this.showModal = false;
    this.closeModal.emit(false);
  }

  confirmerAction() {
    this.showModal = false;
    this.confirmAction.emit(true);
  }
}

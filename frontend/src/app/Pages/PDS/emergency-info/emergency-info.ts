import { CommonModule } from '@angular/common';
import { Component, input } from '@angular/core';
import { AbstractControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pds-emergency-info',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './emergency-info.html',
  styleUrl: '../section-shared.css',
})
export class PdsEmergencyInfo {
  readonly group = input.required<FormGroup>();

  control(name: string): AbstractControl | null {
    return this.group().get(name);
  }

  showError(name: string): boolean {
    const control = this.control(name);
    return !!control && control.touched && control.invalid;
  }
}

import { CommonModule } from '@angular/common';
import { Component, input } from '@angular/core';
import { AbstractControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pds-personal-info',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './personal-info.html',
  styleUrl: '../section-shared.css',
})
export class PdsPersonalInfo {
  readonly group = input.required<FormGroup>();
  readonly sexOptions = input.required<string[]>();
  readonly civilStatusOptions = input.required<string[]>();
  readonly citizenshipTypeOptions = input.required<string[]>();
  readonly citizenStatusOptions = input.required<string[]>();

  control(name: string): AbstractControl | null {
    return this.group().get(name);
  }

  showError(name: string, errorKey?: string): boolean {
    const control = this.control(name);
    if (!control || !control.touched) {
      return false;
    }

    return errorKey ? !!control.getError(errorKey) : control.invalid;
  }
}

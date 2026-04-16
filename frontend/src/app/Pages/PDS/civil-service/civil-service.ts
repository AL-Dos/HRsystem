import { CommonModule } from '@angular/common';
import { Component, input, output } from '@angular/core';
import { FormArray, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pds-civil-service',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './civil-service.html',
  styleUrl: '../section-shared.css',
})
export class PdsCivilService {
  readonly group = input.required<FormGroup>();
  readonly entries = input.required<FormArray<FormGroup>>();
  readonly addEntry = output<void>();
  readonly removeEntry = output<number>();
}

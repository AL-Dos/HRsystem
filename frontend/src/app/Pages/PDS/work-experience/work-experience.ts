import { CommonModule } from '@angular/common';
import { Component, input, output } from '@angular/core';
import { FormArray, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pds-work-experience',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './work-experience.html',
  styleUrl: '../section-shared.css',
})
export class PdsWorkExperience {
  readonly group = input.required<FormGroup>();
  readonly entries = input.required<FormArray<FormGroup>>();
  readonly addEntry = output<void>();
  readonly removeEntry = output<number>();
}

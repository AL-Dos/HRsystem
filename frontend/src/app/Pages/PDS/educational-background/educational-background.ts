import { CommonModule } from '@angular/common';
import { Component, input, output } from '@angular/core';
import { FormArray, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pds-educational-background',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './educational-background.html',
  styleUrl: '../section-shared.css',
})
export class PdsEducationalBackground {
  readonly group = input.required<FormGroup>();
  readonly entries = input.required<FormArray<FormGroup>>();
  readonly educationLevelOptions = input.required<string[]>();
  readonly addEntry = output<void>();
  readonly removeEntry = output<number>();
}

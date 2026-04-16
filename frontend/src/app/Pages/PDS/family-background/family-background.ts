import { CommonModule } from '@angular/common';
import { Component, input, output } from '@angular/core';
import { FormArray, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pds-family-background',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './family-background.html',
  styleUrl: '../section-shared.css',
})
export class PdsFamilyBackground {
  readonly group = input.required<FormGroup>();
  readonly children = input.required<FormArray<FormGroup>>();
  readonly addChild = output<void>();
  readonly removeChild = output<number>();
}

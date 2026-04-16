import { CommonModule } from '@angular/common';
import { Component, computed, inject, signal } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { RouterLink } from '@angular/router';
import { PdsCivilService } from './civil-service/civil-service';
import { PdsEducationalBackground } from './educational-background/educational-background';
import { PdsEmergencyInfo } from './emergency-info/emergency-info';
import { PdsFamilyBackground } from './family-background/family-background';
import { PdsPersonalInfo } from './personal-info/personal-info';
import { PdsTrainingDevelopment } from './training-development/training-development';
import { PdsWorkExperience } from './work-experience/work-experience';

type StepKey =
  | 'personalInfo'
  | 'familyBackground'
  | 'educBackground'
  | 'civilService'
  | 'workExperience'
  | 'trainingDevelopment'
  | 'emergencyInfo';

interface StepDefinition {
  key: StepKey;
  label: string;
  description: string;
}

@Component({
  selector: 'app-pds',
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterLink,
    PdsPersonalInfo,
    PdsFamilyBackground,
    PdsEducationalBackground,
    PdsCivilService,
    PdsWorkExperience,
    PdsTrainingDevelopment,
    PdsEmergencyInfo,
  ],
  templateUrl: './pds.html',
  styleUrl: './pds.css',
})
export class Pds {
  private fb = inject(FormBuilder);

  readonly steps: StepDefinition[] = [
    {
      key: 'personalInfo',
      label: 'Personal Information',
      description: 'Core identity, contact details, and government identifiers.',
    },
    {
      key: 'familyBackground',
      label: 'Family Background',
      description: 'Spouse, parents, and dependent children.',
    },
    {
      key: 'educBackground',
      label: 'Educational Background',
      description: 'Schooling history and qualifications earned.',
    },
    {
      key: 'civilService',
      label: 'Civil Service',
      description: 'Eligibility exams, ratings, and license validity.',
    },
    {
      key: 'workExperience',
      label: 'Work Experience',
      description: 'Employment history, pay grade, and service type.',
    },
    {
      key: 'trainingDevelopment',
      label: 'Training & Development',
      description: 'Learning interventions and sponsoring organizations.',
    },
    {
      key: 'emergencyInfo',
      label: 'Emergency Information',
      description: 'Primary contact during emergencies.',
    },
  ];

  readonly currentStep = signal(0);
  readonly submitMessage = signal('');

  readonly pdsForm = this.fb.group({
    personalInfo: this.fb.group({
      firstName: ['', Validators.required],
      surname: ['', Validators.required],
      middleName: [''],
      extensions: [''],
      birthDate: [''],
      bloodType: [''],
      placeBirth: [''],
      sex: ['', Validators.required],
      civilStatus: ['', Validators.required],
      civilOther: [''],
      heightM: [''],
      weightKg: [''],
      gsisId: [''],
      pagibigId: [''],
      phealthId: [''],
      sssNo: [''],
      tinNo: [''],
      employeeNo: [''],
      citizenshipType: [''],
      citizenStatus: [''],
      dualCitizenCountry: [''],
      addressNo: [''],
      addressSt: [''],
      addressSub: [''],
      addressBarangay: [''],
      addressCity: [''],
      addressProvince: [''],
      addressCode: [''],
      telephone: [''],
      mobile: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    }),
    familyBackground: this.fb.group({
      spouseFname: [''],
      spouseSurname: [''],
      spouseMname: [''],
      spouseExtensions: [''],
      spouseOccupation: [''],
      spouseEmployeer: [''],
      spouseJobAddress: [''],
      telephone: [''],
      fatherFname: [''],
      fatherSurname: [''],
      fatherMname: [''],
      fatherExtensions: [''],
      motherFname: [''],
      motherSurname: [''],
      motherMname: [''],
      children: this.fb.array([this.createChildGroup()]),
    }),
    educBackground: this.fb.group({
      entries: this.fb.array([this.createEducationEntryGroup()]),
    }),
    civilService: this.fb.group({
      entries: this.fb.array([this.createCivilServiceGroup()]),
    }),
    workExperience: this.fb.group({
      entries: this.fb.array([this.createWorkExperienceGroup()]),
    }),
    trainingDevelopment: this.fb.group({
      entries: this.fb.array([this.createTrainingGroup()]),
    }),
    emergencyInfo: this.fb.group({
      contactName: ['', Validators.required],
      relationship: ['', Validators.required],
      contactNo: ['', Validators.required],
      address: ['', Validators.required],
    }),
  });

  readonly currentStepMeta = computed(() => this.steps[this.currentStep()]);
  readonly progressPercentage = computed(
    () => ((this.currentStep() + 1) / this.steps.length) * 100
  );

  readonly sexOptions = ['Male', 'Female'];
  readonly civilStatusOptions = ['Single', 'Married', 'Widowed', 'Separated', 'Other'];
  readonly citizenshipTypeOptions = ['Filipino', 'Dual Citizenship', 'Foreign National'];
  readonly citizenStatusOptions = ['By Birth', 'By Naturalization', 'Other'];
  readonly educationLevelOptions = [
    'Elementary',
    'Secondary',
    'Vocational / Trade',
    'College',
    'Graduate Studies',
  ];

  get personalInfoGroup(): FormGroup {
    return this.pdsForm.get('personalInfo') as FormGroup;
  }

  get familyBackgroundGroup(): FormGroup {
    return this.pdsForm.get('familyBackground') as FormGroup;
  }

  get educBackgroundGroup(): FormGroup {
    return this.pdsForm.get('educBackground') as FormGroup;
  }

  get civilServiceGroup(): FormGroup {
    return this.pdsForm.get('civilService') as FormGroup;
  }

  get workExperienceGroup(): FormGroup {
    return this.pdsForm.get('workExperience') as FormGroup;
  }

  get trainingDevelopmentGroup(): FormGroup {
    return this.pdsForm.get('trainingDevelopment') as FormGroup;
  }

  get emergencyInfoGroup(): FormGroup {
    return this.pdsForm.get('emergencyInfo') as FormGroup;
  }

  get familyChildren(): FormArray<FormGroup> {
    return this.pdsForm.get('familyBackground.children') as FormArray<FormGroup>;
  }

  get educationEntries(): FormArray<FormGroup> {
    return this.pdsForm.get('educBackground.entries') as FormArray<FormGroup>;
  }

  get civilServiceEntries(): FormArray<FormGroup> {
    return this.pdsForm.get('civilService.entries') as FormArray<FormGroup>;
  }

  get workExperienceEntries(): FormArray<FormGroup> {
    return this.pdsForm.get('workExperience.entries') as FormArray<FormGroup>;
  }

  get trainingEntries(): FormArray<FormGroup> {
    return this.pdsForm.get('trainingDevelopment.entries') as FormArray<FormGroup>;
  }

  jumpToStep(index: number): void {
    if (index <= this.currentStep()) {
      this.currentStep.set(index);
      this.submitMessage.set('');
      return;
    }

    if (!this.validateCurrentStep()) {
      return;
    }

    this.currentStep.set(index);
    this.submitMessage.set('');
  }

  nextStep(): void {
    if (this.currentStep() >= this.steps.length - 1) {
      return;
    }

    if (!this.validateCurrentStep()) {
      return;
    }

    this.currentStep.update((value) => value + 1);
    this.submitMessage.set('');
  }

  previousStep(): void {
    if (this.currentStep() > 0) {
      this.currentStep.update((value) => value - 1);
      this.submitMessage.set('');
    }
  }

  addChild(): void {
    this.familyChildren.push(this.createChildGroup());
  }

  removeChild(index: number): void {
    if (this.familyChildren.length > 1) {
      this.familyChildren.removeAt(index);
    }
  }

  addEducationEntry(): void {
    this.educationEntries.push(this.createEducationEntryGroup());
  }

  removeEducationEntry(index: number): void {
    if (this.educationEntries.length > 1) {
      this.educationEntries.removeAt(index);
    }
  }

  addCivilServiceEntry(): void {
    this.civilServiceEntries.push(this.createCivilServiceGroup());
  }

  removeCivilServiceEntry(index: number): void {
    if (this.civilServiceEntries.length > 1) {
      this.civilServiceEntries.removeAt(index);
    }
  }

  addWorkExperienceEntry(): void {
    this.workExperienceEntries.push(this.createWorkExperienceGroup());
  }

  removeWorkExperienceEntry(index: number): void {
    if (this.workExperienceEntries.length > 1) {
      this.workExperienceEntries.removeAt(index);
    }
  }

  addTrainingEntry(): void {
    this.trainingEntries.push(this.createTrainingGroup());
  }

  removeTrainingEntry(index: number): void {
    if (this.trainingEntries.length > 1) {
      this.trainingEntries.removeAt(index);
    }
  }

  saveDraft(): void {
    this.submitMessage.set('Draft captured in the form state. Backend persistence can be wired next.');
  }

  submit(): void {
    this.pdsForm.markAllAsTouched();

    if (this.pdsForm.invalid) {
      this.submitMessage.set('Complete the required fields before submitting the PDS.');
      return;
    }

    console.log('PDS draft payload', this.pdsForm.getRawValue());
    this.submitMessage.set('PDS layout is ready. The form payload is now shaped for API integration.');
  }

  private validateCurrentStep(): boolean {
    const stepGroup = this.getCurrentStepGroup();
    stepGroup.markAllAsTouched();
    stepGroup.updateValueAndValidity();

    if (stepGroup.invalid) {
      this.submitMessage.set(`Complete the required fields in ${this.currentStepMeta().label} before continuing.`);
      return false;
    }

    return true;
  }

  private getCurrentStepGroup(): FormGroup {
    return this.pdsForm.get(this.steps[this.currentStep()].key) as FormGroup;
  }

  private createChildGroup(): FormGroup {
    return this.fb.group({
      childName: [''],
      birthDate: [''],
    });
  }

  private createEducationEntryGroup(): FormGroup {
    return this.fb.group({
      educationLevel: [''],
      schoolName: [''],
      course: [''],
      attendanceFrom: [''],
      attendanceTo: [''],
      levelEarned: [''],
      graduateDate: [''],
      scholarshipHonors: [''],
    });
  }

  private createCivilServiceGroup(): FormGroup {
    return this.fb.group({
      cse: [''],
      rating: [''],
      examDate: [''],
      examPlace: [''],
      licenseNumber: [''],
      validityDate: [''],
    });
  }

  private createWorkExperienceGroup(): FormGroup {
    return this.fb.group({
      datesFrom: [''],
      datesTo: [''],
      positionTitle: [''],
      company: [''],
      salary: [''],
      payGrade: [''],
      status: [''],
      govService: [false],
    });
  }

  private createTrainingGroup(): FormGroup {
    return this.fb.group({
      title: [''],
      attendFrom: [''],
      attendTo: [''],
      hours: [''],
      typeOf: [''],
      sponsoredBy: [''],
    });
  }
}

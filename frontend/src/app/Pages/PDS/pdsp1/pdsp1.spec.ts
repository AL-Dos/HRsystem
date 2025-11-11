import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PDSp1 } from './pdsp1';

describe('PDSp1', () => {
  let component: PDSp1;
  let fixture: ComponentFixture<PDSp1>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PDSp1]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PDSp1);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

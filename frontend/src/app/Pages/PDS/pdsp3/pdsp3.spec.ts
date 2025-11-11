import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PDSp3 } from './pdsp3';

describe('PDSp3', () => {
  let component: PDSp3;
  let fixture: ComponentFixture<PDSp3>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PDSp3]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PDSp3);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PDSp2 } from './pdsp2';

describe('PDSp2', () => {
  let component: PDSp2;
  let fixture: ComponentFixture<PDSp2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PDSp2]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PDSp2);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

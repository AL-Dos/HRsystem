import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Idcreation } from './idcreation';

describe('Idcreation', () => {
  let component: Idcreation;
  let fixture: ComponentFixture<Idcreation>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Idcreation]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Idcreation);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

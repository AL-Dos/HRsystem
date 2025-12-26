import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceRendered } from './service-rendered';

describe('ServiceRendered', () => {
  let component: ServiceRendered;
  let fixture: ComponentFixture<ServiceRendered>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ServiceRendered]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ServiceRendered);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

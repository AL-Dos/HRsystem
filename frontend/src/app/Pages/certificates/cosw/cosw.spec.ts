import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Cosw } from './cosw';

describe('Cosw', () => {
  let component: Cosw;
  let fixture: ComponentFixture<Cosw>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Cosw]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Cosw);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

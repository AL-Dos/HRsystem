import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Regular } from './regular';

describe('Regular', () => {
  let component: Regular;
  let fixture: ComponentFixture<Regular>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Regular]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Regular);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

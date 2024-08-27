import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputProcessosComponent } from './input-processos.component';

describe('InputProcessosComponent', () => {
  let component: InputProcessosComponent;
  let fixture: ComponentFixture<InputProcessosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InputProcessosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InputProcessosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabelaProcessosComponent } from './tabela-processos.component';

describe('TabelaProcessosComponent', () => {
  let component: TabelaProcessosComponent;
  let fixture: ComponentFixture<TabelaProcessosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TabelaProcessosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TabelaProcessosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

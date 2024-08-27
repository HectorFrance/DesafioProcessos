import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TabelaProcessosComponent } from './components/tabela-processos/tabela-processos.component';
import { InputProcessosComponent } from './components/input-processos/input-processos.component'
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [InputProcessosComponent, TabelaProcessosComponent,CommonModule,RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'processos-front';
}

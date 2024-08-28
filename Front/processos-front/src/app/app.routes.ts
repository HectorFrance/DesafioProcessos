import { Routes } from '@angular/router';
import { TabelaProcessosComponent } from './components/tabela-processos/tabela-processos.component';
import { InputProcessosComponent } from './components/input-processos/input-processos.component';

export const routes: Routes = [
    {path:'table',component: TabelaProcessosComponent},
    {path:'form', component: InputProcessosComponent}
];

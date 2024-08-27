import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Processo } from '../../model/Processo';
import { ProcessoService } from '../../service/processo.service';
import { MunicipioService } from '../../service/municipio.service';
import { UfService } from '../../service/uf.service';
import { Uf } from '../../model/Uf';

@Component({
  selector: 'app-tabela-processos',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './tabela-processos.component.html',
  styleUrl: './tabela-processos.component.css'
})
export class TabelaProcessosComponent {

  constructor(private processoService: ProcessoService, private municipioService:MunicipioService, 
    private ufService:UfService){ }

  processos:Processo[]=[];
  p:Processo= new Processo;
  uf = new Uf();
  carregarProcessos():void{

    this.processoService.getAll()
    .subscribe(retornoApi => this.processos = retornoApi);
    this.p=this.processos[4];
  }

  nomeUf(id:number):string{

    this.ufService.getById(id).subscribe(retornoApi => this.uf = retornoApi);
    alert(this.uf.nome)
    return this.uf.nome;
  }

  ngOnInit(){
    this.carregarProcessos();
  }

  
}

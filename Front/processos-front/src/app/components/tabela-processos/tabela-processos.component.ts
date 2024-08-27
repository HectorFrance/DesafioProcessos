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

  nomeUf(id:number){
    this.ufService.getById(id).subscribe((retornoApi) => {
      let estado:Uf=retornoApi;
      console.log(estado)
      return estado.nome;
    });
  }

  formatarNpu(npu:string):string{
    let npuFormat = npu;
    npuFormat= npuFormat.replace(/(\d{7})(\d{2})(\d{4})(\d{1})(\d{2})(\d{4})/,"$1-$2.$3.$4.$5.$6")
    return npuFormat
}
  formatarData(data:Date):string{
    let dataFormat:Date = new Date(data);
    return dataFormat.toLocaleDateString("pt-BR");
  }

  ngOnInit(){
    this.carregarProcessos();
  }

  
}

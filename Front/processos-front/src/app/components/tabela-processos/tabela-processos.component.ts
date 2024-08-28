import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Processo } from '../../model/Processo';
import { ProcessoService } from '../../service/processo.service';
import { MunicipioService } from '../../service/municipio.service';
import { UfService } from '../../service/uf.service';
import { Router, RouterLink } from '@angular/router';


@Component({
  selector: 'app-tabela-processos',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterLink],
  templateUrl: './tabela-processos.component.html',
  styleUrl: './tabela-processos.component.css'
})
export class TabelaProcessosComponent implements OnInit{

  constructor(private processoService: ProcessoService, private municipioService:MunicipioService, 
    private ufService:UfService, private  router:Router){ }


  processos:Processo[]=[];
  carregarProcessos():void{

    this.processoService.getAll()
    .subscribe((retornoApi) => {
      this.processos = retornoApi
      
    });
  }

  deleteById(id:number){
    this.processoService.delete(id).subscribe(retornoApi =>{
      this.carregarProcessos();
      alert("Processo Deletado")
    })
  }

  findById(p:Processo){
    const processoTransf = p;
    this.router.navigate(['/form'],{state:{processo:processoTransf}})
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

  AfterViewInit(){
    this.carregarProcessos();
  }
  
}

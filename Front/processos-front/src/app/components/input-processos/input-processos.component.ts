import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UfService } from '../../service/uf.service';
import { Uf } from '../../model/Uf';
import { Municipio } from '../../model/Municipio';
import { MunicipioService } from '../../service/municipio.service';


@Component({
  selector: 'app-input-processos',
  standalone: true,
  imports: [FormsModule, CommonModule,HttpClientModule],
  templateUrl: './input-processos.component.html',
  styleUrl: './input-processos.component.css'
})
export class InputProcessosComponent {

  constructor(private ufService:UfService, private municipioService:MunicipioService){

  }
  ufs:Uf[]=[];
  municipios:Municipio[]=[];
  ufSelecionada:number = 0;
  municipioSelecionada:number=0;
  btnCadastro:boolean =true;
  selectMunicipioDisable:boolean=true;


  carregarEstados():void{

    this.ufService.getAll()
    .subscribe(retornoApi => this.ufs = retornoApi);
  }

  carregarMunicipios(uf:number):void{
    this.municipioService.getAllByUf(uf).subscribe(retornoApi => this.municipios = retornoApi)
  }

  selcionarEstado(event:Event):void{
    
    const estado = (event.target as HTMLSelectElement).value;
    console.log(event)
    console.log(estado)

    if(estado !== 'Selecione o Estado'){
      this.selectMunicipioDisable=false
    }
    this.carregarMunicipios(parseInt(estado));
    
  }

  ngOnInit(){
    this.carregarEstados();
  }
}

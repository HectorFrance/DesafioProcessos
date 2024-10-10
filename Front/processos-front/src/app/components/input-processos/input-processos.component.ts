import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UfService } from '../../service/uf.service';
import { Uf } from '../../model/Uf';
import { Municipio } from '../../model/Municipio';
import { MunicipioService } from '../../service/municipio.service';
import { Processo } from '../../model/Processo';
import { ProcessoService } from '../../service/processo.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';


@Component({
  selector: 'app-input-processos',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule, RouterLink],
  templateUrl: './input-processos.component.html',
  styleUrl: './input-processos.component.css'
})
export class InputProcessosComponent {

  constructor(private ufService: UfService, private municipioService: MunicipioService,
    private processoService: ProcessoService, private router: Router, private route: ActivatedRoute) {

  }
  processo: Processo = new Processo;
  ufs: Uf[] = [];
  municipios: Municipio[] = [];
  ufSelecionada: number = 0;
  municipioSelecionada: number = 0;
  btnCadastro: boolean = true;
  selectMunicipioDisable: boolean = true;
  submit: string = "Cadastrar";
  id: number = 0;


  createOrUpdate(): void {

    if (this.processo.id > 0) {
      this.updateProcesso();
    } else {
      this.createProcesso();
    }
  }


  createProcesso(): void {
    this.processoService.create(this.processo).subscribe(retornoApi => {

      this.processo = new Processo();
      alert("Processo Cadastrado com sucesso")
    })
  }

  updateProcesso(): void {
    this.processoService.update(this.processo).subscribe(retornoApi => {
      alert("Processo Alterado")
    })
  }

   carregarProcesso(id: number) {
    let p: Processo = new Processo
     this.processoService.getById(id)
      .subscribe(retornoApi => {
        this.processo=retornoApi;
        this.processo.uf = this.processo.ufId + "";
        this.carregarMunicipios(this.processo.ufId);
        this.processo.municipio = this.processo.municipioId + "";
        console.log(retornoApi)
      });
      
  }

  carregarEstados(): void {

    this.ufService.getAll()
      .subscribe(retornoApi => this.ufs = retornoApi);
  }

  carregarMunicipios(uf: number): void {
    this.municipioService.getAllByUf(uf).subscribe(retornoApi => this.municipios = retornoApi)
  }

  selcionarEstado(event: Event): void {

    const estado = (event.target as HTMLSelectElement).value;
    console.log(event)
    console.log(estado)

    if (estado !== 'Selecione o Estado') {
      this.selectMunicipioDisable = false
    }
    this.processo.municipio = "0";
    this.carregarMunicipios(parseInt(estado));

  }

   ngOnInit() {

    this.carregarEstados();
    this.processo.municipio = "0";
    this.processo.uf = "0";
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    console.log(this.id)

    if (this.id > 0) {
      this.submit = "Alterar"
      this.carregarProcesso(this.id);
    } 
  }


}

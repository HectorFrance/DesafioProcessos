import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Municipio } from '../model/Municipio';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MunicipioService {

  private urlF:string='https://servicodados.ibge.gov.br/api/v1/localidades/estados/';
  private urlS:string='/municipios';



  constructor(private http:HttpClient) { }

  getAllByUf(uf:number):Observable<Municipio[]>{
    return this.http.get<Municipio[]>(this.urlF+uf+this.urlS);
  }
}

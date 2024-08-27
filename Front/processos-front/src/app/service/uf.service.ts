import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Uf } from '../model/Uf';

@Injectable({
  providedIn: 'root'
})
export class UfService {

  private url:string='https://servicodados.ibge.gov.br/api/v1/localidades/estados'
  constructor(private http:HttpClient) { }

  getAll():Observable<Uf[]>{
    return this.http.get<Uf[]>(this.url);
  }

  getById(id:number):Observable<Uf>{
    return this.http.get<Uf>(this.url+"/"+id);
  }
}
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Processo } from '../model/Processo';

@Injectable({
  providedIn: 'root'
})
export class ProcessoService {


  private url:string ='http://localhost:8080/processos'
  
  constructor(private http:HttpClient) { }

  getAll():Observable<Processo[]>{
    return this.http.get<Processo[]>(this.url);
  }
}

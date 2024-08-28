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

  create(obj:Processo):Observable<Processo>{
    return this.http.post<Processo>(this.url,obj);
  }

  update(obj:Processo):Observable<Processo>{
    return this.http.put<Processo>(this.url+"/"+obj.id,obj);
  }

  delete(id:number):Observable<Processo>{
    return this.http.delete<Processo>(this.url+"/"+id);
  }
}

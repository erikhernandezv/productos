import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuarios } from '../models/usuarios';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private baseEndpoint = 'http://localhost:8090/erik/api/user';

  private cabeceras: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  public listar(): Observable<Usuarios[]>{
    return this.http.get<Usuarios[]>(`${this.baseEndpoint}/all`);
  }
}

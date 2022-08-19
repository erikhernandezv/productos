import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Inventario } from '../models/inventario';


@Injectable({
  providedIn: 'root'
})
export class InventarioService {

  private baseEndpoint = 'http://localhost:8090/erik/api/mercancia';

  private cabeceras: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  public listar(): Observable<Inventario[]>{
    return this.http.get<Inventario[]>(`${this.baseEndpoint}/all`);
  }

  public listarPaginas(page: string, size: string): Observable<any>{
    const params = new HttpParams()
    .set('page', page)
    .set('size', size);
    // tslint:disable-next-line:object-literal-shorthand
    return this.http.get<any>(`${this.baseEndpoint}/pagina`, {params: params});
  }

  public ver(id: number): Observable<Inventario>{
    return this.http.get<Inventario>(`${this.baseEndpoint}/${id}`);
  }

  /** falta verificar */
  public create(inventario: Inventario): Observable<Inventario>{
    return this.http.post<Inventario>(`${this.baseEndpoint}/save`, inventario, { headers: this.cabeceras });
  }

  /** falta verificar */
  public editar(inventario: Inventario): Observable<Inventario>{
    return this.http.put<Inventario>(`${this.baseEndpoint}/${inventario.idMercancia}`, inventario, { headers: this.cabeceras });
  }

  public eliminar(id: number): Observable<any>{
    return this.http.get<any>(`${this.baseEndpoint}/delete/${id}`);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Empleados } from '../models/empleados';


@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  private baseEndpoint = 'http://localhost:8090/tercero/empleado';

  private cabeceras: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }

  public listar(): Observable<Empleados[]>{
    return this.http.get<Empleados[]>(this.baseEndpoint);
  }

  public listarPaginas(page: string, size: string): Observable<any>{
    const params = new HttpParams()
    .set('page', page)
    .set('size', size);
    // tslint:disable-next-line:object-literal-shorthand
    return this.http.get<any>(`${this.baseEndpoint}/pagina`, {params: params});
  }

  public ver(id: number): Observable<Empleados>{
    return this.http.get<Empleados>(`${this.baseEndpoint}/${id}`);
  }

  public create(empleado: Empleados): Observable<Empleados>{
    return this.http.post<Empleados>(this.baseEndpoint, empleado, { headers: this.cabeceras });
  }

  public editar(empleado: Empleados): Observable<Empleados>{
    return this.http.put<Empleados>(`${this.baseEndpoint}/${empleado.id}`, empleado, { headers: this.cabeceras });
  }

  public eliminar(id: number): Observable<void>{
    return this.http.delete<void>(`${this.baseEndpoint}/${id}`);
  }
}

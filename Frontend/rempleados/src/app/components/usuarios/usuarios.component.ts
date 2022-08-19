import { Component, OnInit, Input, Output, EventEmitter, AfterContentChecked } from '@angular/core';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuarios } from 'src/app/models/usuarios';
import { UsuarioService } from 'src/app/services/usuario.service';
import { compilePipeFromMetadata } from '@angular/compiler';
import { allowedNodeEnvironmentFlags } from 'process';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styles: [
  ]
})
export class UsuariosComponent implements OnInit {

  public title = 'Usuarios';
  public color = '';
  public mensaje = '';
  public visible = false;

  usuarios: Usuarios[];

  // Captura errores vista
  error: any;
  id: number;

  @Output()
  envRes: EventEmitter<string> = new EventEmitter<string>();

  constructor(private service: UsuarioService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(usuario => this.usuarios = usuario);
  }

  onChange(value: string) {
    this.envRes.emit(value);
    //console.log("Usuario es :"+value );
    //alert("Usuario es :"+value + " id= "+this.id+" idusuario= ");
  }

}

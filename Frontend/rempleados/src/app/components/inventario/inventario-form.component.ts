import { Component, OnInit } from '@angular/core';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import { ActivatedRoute, Router } from '@angular/router';
import { Inventario } from 'src/app/models/inventario';
import { InventarioService } from 'src/app/services/inventario.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Usuarios } from 'src/app/models/usuarios';


@Component({
  selector: 'app-inventario-form',
  templateUrl: './inventario-form.component.html',
  styles: [
  ]
})
export class InventarioFormComponent implements OnInit {

  public title = 'Crear producto';
  public color = '';
  public mensaje = '';
  public visible = false;
  id: number;

  inventario: Inventario = new Inventario();
  usuarios: Usuarios[];

  // Captura errores vista
  error: any;
  idUsuario: string;

  constructor(private service: InventarioService, private sUser: UsuarioService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      const id: number = +params.get('id');
      if(id){
        this.service.ver(id).subscribe(inventario => this.inventario = inventario)
      }
    });

    this.sUser.listar().subscribe(usuario => this.usuarios = usuario);
  }

  public crear(){

    this.service.create(this.inventario).subscribe(inventario => {
      // console.log("Crear de invetario-form");
      // console.log(inventario);
      // alert
      this.color = 'green';
      this.mensaje = `Producto ${inventario.nombreProducto} creado con exito`;
      this.visible = true;

      setTimeout(function(){
       }, 10000);

       this.router.navigate(['/inventario']);
    }, err => {
      if (err.status === 400){
        this.error = err.error;
        // console.log(this.error);
      }
    });
  }

  public editar(){

    this.service.editar(this.inventario).subscribe(inventario => {
      console.log(inventario);
      // alert
      this.color = 'green';
      this.mensaje = `Producto ${inventario.nombreProducto} se ha actualizado con exito`;
      this.visible = true;

      setTimeout(function(){ 
        this.router.navigate(['/inventario']);
       }, 10000);

    }, err => {
      if (err.status === 400){
        this.error = err.error;
      }
    });
  }

  public optionSelected(event: any) {
    this.idUsuario = event;
    this.inventario.idUsuario = 1;
    // console.log("this.idUsuario "+this.idUsuario+" this.inventario.idUsuario "+this.inventario.idUsuario);
  }

}

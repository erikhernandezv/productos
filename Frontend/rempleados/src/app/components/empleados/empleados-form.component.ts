import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empleados } from 'src/app/models/empleados';
import { EmpleadoService } from 'src/app/services/empleado.service';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-empleados-form',
  templateUrl: './empleados-form.component.html',
  styles: [
  ]
})
export class EmpleadosFormComponent implements OnInit {

  title = 'Crear Empleados';
  public color: string;
  public mensaje: string;
  public visible: boolean = false;
  public areas : string[] = ["ADMINISTRATIVA","FINANCIERA","COMPRAS","INFRAESTRUCTURA","OPERACION","RECURSOS HUMANOS","SERVICIOS_VARIOS","TI"];
  public tiposDocumentos = ['CEDULA_DE_CIUDADANIA',"CEDULA_EXTRANJERIA","PASAPORTE", "PERMISO_ESPECIAL"];

  empleado: Empleados = new Empleados();

  // Captura errores vista
  error: any;

  constructor(private service: EmpleadoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      const id: number = +params.get('id');
      if(id){
        this.service.ver(id).subscribe(empleado => this.empleado = empleado)
      }
    });
  }

  public crear(){

    this.service.create(this.empleado).subscribe(empleado => {
      console.log(empleado);
      // alert
      this.color = 'green';
      this.mensaje = `Empleado ${empleado.emp_nombre1} creado con exito`;
      this.visible = true;

      this.router.navigate(['/empleados']);
    }, err => {
      if (err.status === 400){
        this.error = err.error;
        //console.log(this.error);
      }
    });
  }

  public editar(){

    this.service.editar(this.empleado).subscribe(empleado => {
      console.log(empleado);
      // alert
      this.color = 'green';
      this.mensaje = `Empleado ${empleado.emp_nombre1} se ha actualizado con exito`;
      this.visible = true;

      this.router.navigate(['/empleados']);
    }, err => {
      if (err.status === 400){
        this.error = err.error;
      }
    });
  }

}

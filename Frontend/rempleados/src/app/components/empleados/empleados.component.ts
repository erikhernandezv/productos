import { Component, OnInit } from '@angular/core';
import { Empleados } from 'src/app/models/empleados';
import { EmpleadoService } from 'src/app/services/empleado.service';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import { compilePipeFromMetadata } from '@angular/compiler';
import { allowedNodeEnvironmentFlags } from 'process';


@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent implements OnInit {

  title = 'Empleados';
  empleados: Empleados[];
  faEdit = faEdit;
  faTrash = faTrash;

  constructor(private service: EmpleadoService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(empleados => this.empleados = empleados);
  }

  public eliminar(empleado: Empleados): void{
    //alert(empleado.emp_consecutivo);
    var id: number = 0;//empleado.emp_consecutivo;
    var emlEli: string  = empleado.emp_nombre1+' '+empleado.emp_nombre2;

    if (confirm(`Esta seguro que quiere eliminar a ${empleado.emp_nombre1} ${empleado.emp_nombre2}`)){
      this.service.eliminar(id).subscribe(() =>{
        this.empleados = this.empleados.filter(e => e !== empleado);
        alert(`Empleado ${emlEli} eliminado con exito`);
      });
    }
  }
}

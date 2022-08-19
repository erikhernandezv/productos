import { Component, OnInit } from '@angular/core';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import { Inventario } from 'src/app/models/inventario';
import { InventarioService } from 'src/app/services/inventario.service';
import { compilePipeFromMetadata } from '@angular/compiler';
import { allowedNodeEnvironmentFlags } from 'process';

@Component({
  selector: 'app-inventario',
  templateUrl: './inventario.component.html',
  styles: [
  ]
})
export class InventarioComponent implements OnInit {

  title = 'Inventarios';
  inventarios: Inventario[];
  faEdit = faEdit;
  faTrash = faTrash;

  constructor(private service: InventarioService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(inventarios => this.inventarios = inventarios);
  }

  public eliminar(inventory: Inventario): void{
    const id = inventory.idMercancia;
    const emlEli: string  = inventory.nombreProducto;

    if (confirm(`Esta seguro que quiere eliminar el producto ${emlEli}`)){
      this.service.eliminar(id).subscribe(() => {
        this.inventarios = this.inventarios.filter(e => e !== inventory);
        alert(`Producto ${emlEli} eliminado del inventario con exito`);
      });
    }
  }

}

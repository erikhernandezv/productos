import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InventarioFormComponent } from './components/inventario/inventario-form.component';
import { InventarioComponent } from './components/inventario/inventario.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'inventario'},
  {path: '*', pathMatch: 'full', redirectTo: 'inventario'},
  {path: 'inventario', component: InventarioComponent},
  {path: 'inventario/form', component: InventarioFormComponent},
  {path: 'inventario/form/:id', component: InventarioFormComponent},
  {path: 'usuarios', component: UsuariosComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

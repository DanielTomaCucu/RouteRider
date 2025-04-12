import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusRoutesPage } from './busRoutes.page';

const routes: Routes = [
  {
    path: '',
    component: BusRoutesPage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BusRoutesRoutingModule {}

import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BusRoutesRoutingModule } from './busRoutes-routing.module';
import {BusRoutesPage} from "./busRoutes.page";

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    BusRoutesRoutingModule
  ],
  declarations: [BusRoutesPage]
})
export class BusRoutesModule {}

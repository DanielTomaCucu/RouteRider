import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StopsComponent} from "./stops.component";
import {IonicModule} from "@ionic/angular";
import {FormsModule} from "@angular/forms";
import {StopsRoutingModule} from "./stops-routing.module";



@NgModule({
  declarations: [StopsComponent],
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    StopsRoutingModule
  ]
})
export class StopsModule { }

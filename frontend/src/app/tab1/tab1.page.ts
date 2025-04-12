import {Component, OnInit} from '@angular/core';
import {RouteData} from "../interfaces/bus-routes";
import {BusRoutesService} from "./bus-routes.service";

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: false,
})
export class Tab1Page  implements OnInit{
  routes: RouteData[] = [];
  isLoading = false;

  constructor(private busRoutesService: BusRoutesService) {}

  ngOnInit() {
    this.loadRoutes();
  }

  loadRoutes() {
    this.isLoading = true;

    this.busRoutesService.getAllRoutes().subscribe({
      next: (data) => {
        this.routes = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error fetching routes:', err);
        this.isLoading = false;
      }
    });
  }

  doRefresh(event: any) {
    this.loadRoutes();

    setTimeout(() => {
      event.target.complete();
    }, 1000);
  }
}

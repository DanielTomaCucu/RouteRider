import {Component, OnInit} from '@angular/core';
import {RouteData} from "../interfaces/bus-routes";
import {BusRoutesService} from "./bus-routes.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-busRoutes',
  templateUrl: 'busRoutes.html',
  styleUrls: ['busRoutes.scss'],
  standalone: false,
})
export class BusRoutesPage implements OnInit{
  routes: RouteData[] = [];
  isLoading = false;

  constructor(private busRoutesService: BusRoutesService, private router: Router) {}

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

  goToStops(routeId:number){
    this.router.navigate(['/tabs/busRoutes', routeId, 'stops']);

  }
}

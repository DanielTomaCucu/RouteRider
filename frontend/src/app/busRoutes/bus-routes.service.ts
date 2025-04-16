import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RouteData, Stops} from "../interfaces/bus-routes";

@Injectable({
  providedIn: 'root'
})
export class BusRoutesService {

  private apiUrl = 'http://localhost:8080/api/routes';

  constructor(private http: HttpClient) { }

  getAllRoutes(): Observable<RouteData[]> {
    return this.http.get<RouteData[]>(this.apiUrl);
  }

  getStopsByRoute(routeId: number): Observable<{ outbound: Stops[]; inbound: Stops[] }> {
    return this.http.get<{ outbound: Stops[]; inbound: Stops[] }>(`${this.apiUrl}/${routeId}/stops`);
  }
}

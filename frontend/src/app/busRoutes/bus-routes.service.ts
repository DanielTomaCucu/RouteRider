import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RouteData} from "../interfaces/bus-routes";

@Injectable({
  providedIn: 'root'
})
export class BusRoutesService {

  private apiUrl = 'http://localhost:8080/api/routes';

  constructor(private http: HttpClient) { }

  getAllRoutes(): Observable<RouteData[]> {
    return this.http.get<RouteData[]>(this.apiUrl);
  }
}

import { Component, OnInit } from '@angular/core';
import {Stops} from "../../interfaces/bus-routes";
import {BusRoutesService} from "../bus-routes.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-stops',
  templateUrl: './stops.component.html',
  styleUrls: ['./stops.component.scss'],
  standalone:false
})
export class StopsComponent  implements OnInit {

  outboundStops: Stops[] = [];
  inboundStops: Stops[] = [];
  routeId:number =0;
  currentDirection: 'outbound' | 'inbound' = 'outbound';

  constructor(private stopsService: BusRoutesService, private route:ActivatedRoute) {}

  ngOnInit() {
    this.route.paramMap.subscribe(param => {
      const id = param.get('routeId');
      if (id) {
        this.routeId = +id;
        this.stopsService.getStopsByRoute(this.routeId).subscribe(data => {
          this.outboundStops = data.outbound;
          this.inboundStops = data.inbound;
        });
      }
    });
  }

  segmentChanged(event: any) {
    this.currentDirection = event.detail.value;
  }

  /**
   * Format time string to display friendly format
   */
  formatTime(timeString?: string): string {
    if (!timeString) return 'N/A';

    // Rest of your function remains the same
    try {
      const date = new Date(timeString);
      if (!isNaN(date.getTime())) {
        return date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
      }
    } catch (e) {
      // Not an ISO date, continue with other formats
    }

    // If already in HH:MM:SS format, just extract HH:MM
    if (timeString.includes(':')) {
      return timeString.split(':').slice(0, 2).join(':');
    }

    return timeString;
  }

  get displayedStops(): Stops[] {
    return this.currentDirection === 'outbound'
      ? this.outboundStops
      : this.inboundStops;
  }
}

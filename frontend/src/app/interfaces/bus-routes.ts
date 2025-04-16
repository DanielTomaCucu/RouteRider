export interface RouteData {
  routeId: number;
  routeShortName: string;
  routeLongName: string;
  routeDescription: string;
  routeColor: string;
  routeTextColor: string;
}

export interface Stops {
  stopId: number;
  stopName: string;
  stopDescription: string;
  stopLat: number;
  stopLon: number;
  stopUrl: string;
  stopTimes: StopsTimes[];
}

export interface StopsTimes {
  arrivalTime: string;
  departureTime: string;
}

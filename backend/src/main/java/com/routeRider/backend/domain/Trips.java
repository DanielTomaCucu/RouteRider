package com.routeRider.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trips")
public class Trips {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private String tripId;

    @Column(name = "route_id")
    private Integer routeId;

    @Column( name = "service_id")
    private String serviceId;

    @Column(name = "trip_headsign")
    private String tripHeadsign;

    @Column( name = "direction_id")
    private Integer directionId;

    @Column(name = "shape_id")
    private String shapeId;

}

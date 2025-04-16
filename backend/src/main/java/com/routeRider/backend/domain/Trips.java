package com.routeRider.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.RouteMatcher;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Routes route;

    @Column( name = "service_id")
    private String serviceId;

    @Column(name = "trip_headsign")
    private String tripHeadsign;

    @Column( name = "direction_id")
    private Integer directionId;

    @Column(name = "shape_id")
    private String shapeId;

    @OneToMany(mappedBy = "trips", cascade = CascadeType.ALL)
    private List<StopTimes> stopTimes ;

}

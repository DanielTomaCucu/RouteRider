package com.routeRider.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stops_times")
public class StopTimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stop_sequence;

    @Column(name = "trip_id")
    private String tripId;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "stop_id")
    private Integer stopId;

}

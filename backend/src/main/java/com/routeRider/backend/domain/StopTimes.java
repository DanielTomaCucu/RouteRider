package com.routeRider.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trips trips;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "departure_time")
    private LocalTime departureTime;

   @ManyToOne
   @JoinColumn(name = "stop_id" , nullable = false)
    private Stops stopId;

}

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
@Table(name = "stops")
public class Stops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stop_id;

    @Column(name="stop_name")
    private String stopName;

    @Column(name = "stop_desc")
    private String stopDesc;

    @Column( name = "stop_lat")
    private Double stopLat;

    @Column(name = "stop_lon")
    private Double stopLon;

    @Column(name = "stop_url")
    private String stopUrl;

}

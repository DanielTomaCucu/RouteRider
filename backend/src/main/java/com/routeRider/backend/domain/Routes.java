package com.routeRider.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "route_short_name", nullable = false)
    private String routeShortName;

    @Column(name = "route_long_name", nullable = false)
    private String routeLongName;

    @Column(name = "route_desc")
    private String routeDesc;

    @Column(name = "route_url")
    private String routeUrl;

    @Column(name = "route_color")
    private String routeColor;

    @Column(name = "route_text_color")
    private String routeTextColor;

    @Column(name = "route_sort_order")
    private int routeSortOrder;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trips> trips;
}

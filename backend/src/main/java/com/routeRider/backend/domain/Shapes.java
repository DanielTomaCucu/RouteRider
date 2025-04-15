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
@Table(name = "shapes")
public class Shapes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String shape_id;

    @Column(name = "shape_pt_lat")
    private double shapePtLat;

    @Column(name = "shape_pt_lon")
    private double shapePtLon;

    @Column(name = "shape_pt_sequence")
    private int shapePtSequence;

}

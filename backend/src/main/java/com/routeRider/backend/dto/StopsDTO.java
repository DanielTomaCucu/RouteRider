package com.routeRider.backend.dto;

import com.routeRider.backend.domain.StopTimes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StopsDTO {
    private int stopId;
    private String stopName;
    private String stopDescription;
    private Double stopLat;
    private Double stopLon;
    private String stopUrl;
    private List<StopsTimesDTO> stopTimes = new ArrayList<>();


}

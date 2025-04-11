package com.routeRider.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoutesDTO {

    private Integer routeId;
    private String routeShortName;
    private String routeLongName;
    private String routeDescription;
    private String routeColor;
    private String routeTextColor;
}

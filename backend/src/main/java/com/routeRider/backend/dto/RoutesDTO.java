package com.routeRider.backend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class RoutesDTO {

    private Integer routeId;
    private String routeShortName;
    private String routeLongName;
    private String routeDescription;
    private String routeColor;
    private String routeTextColor;

}

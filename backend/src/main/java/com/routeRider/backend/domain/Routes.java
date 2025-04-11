package com.routeRider.backend.domain;

import jakarta.persistence.*;
import lombok.*;

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

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public String getRouteDesc() {
        return routeDesc;
    }

    public void setRouteDesc(String routeDesc) {
        this.routeDesc = routeDesc;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public void setRouteUrl(String routeUrl) {
        this.routeUrl = routeUrl;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    public void setRouteTextColor(String routeTextColor) {
        this.routeTextColor = routeTextColor;
    }

    public int getRouteSortOrder() {
        return routeSortOrder;
    }

    public void setRouteSortOrder(int routeSortOrder) {
        this.routeSortOrder = routeSortOrder;
    }
}

package com.routeRider.backend.controller;

import com.routeRider.backend.dto.RoutesDTO;
import com.routeRider.backend.service.RoutsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RoutesController {

    private final RoutsService routesService;

    @GetMapping
    public ResponseEntity<List<RoutesDTO>> getRoutes() {
        List<RoutesDTO> routes = routesService.getAllRoutes();
        return ResponseEntity.ok(routes);
    }
}

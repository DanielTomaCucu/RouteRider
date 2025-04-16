package com.routeRider.backend.controller;

import com.routeRider.backend.dto.StopsDTO;
import com.routeRider.backend.service.RoutsService;
import com.routeRider.backend.service.StopsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/routes/")
@RequiredArgsConstructor
public class StopsController {
    private final StopsService stopsService;

    @GetMapping("/{id}/stops")
    public ResponseEntity<Map<String, List<StopsDTO>>> getStopsByRouteId(@PathVariable int id) {
        return ResponseEntity.ok(stopsService.getStopsByRouteDirection(id));
    }

}

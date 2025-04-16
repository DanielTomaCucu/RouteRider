package com.routeRider.backend.service;

import com.routeRider.backend.domain.Routes;
import com.routeRider.backend.domain.StopTimes;
import com.routeRider.backend.domain.Trips;
import com.routeRider.backend.dto.StopsDTO;
import com.routeRider.backend.mapper.StopsMapper;
import com.routeRider.backend.repository.RoutesRepository;
import com.routeRider.backend.repository.TripsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StopsService {
    private final RoutesRepository routesRepository;
    private final TripsRepository tripsRepository;
    private final StopsMapper stopsMapper;

    public Map<String, List<StopsDTO>> getStopsByRouteDirection(Integer routeId) {
        Routes route = routesRepository.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Route not found"));

        // Get all trips for this route
        List<Trips> trips = tripsRepository.findByRoute(route);

        // Find first trip for each direction
        Trips outboundTrip = trips.stream()
                .filter(t -> t.getDirectionId() == 0)
                .findFirst()
                .orElse(null);

        Trips inboundTrip = trips.stream()
                .filter(t -> t.getDirectionId() == 1)
                .findFirst()
                .orElse(null);

        List<StopsDTO> outboundStops = new ArrayList<>();
        List<StopsDTO> inboundStops = new ArrayList<>();

        if (outboundTrip != null) {
            outboundStops = outboundTrip.getStopTimes().stream()
                    .sorted(Comparator.comparing(StopTimes::getStop_sequence))
                    .map(st -> stopsMapper.toDto(st.getStopId()))
                    .collect(Collectors.toList());
        }

        if (inboundTrip != null) {
            inboundStops = inboundTrip.getStopTimes().stream()
                    .sorted(Comparator.comparing(StopTimes::getStop_sequence))
                    .map(st -> stopsMapper.toDto(st.getStopId()))
                    .collect(Collectors.toList());
        }

        Map<String, List<StopsDTO>> result = new HashMap<>();
        result.put("outbound", outboundStops);
        result.put("inbound", inboundStops);
        return result;
    }

}

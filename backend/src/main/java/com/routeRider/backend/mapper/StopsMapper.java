package com.routeRider.backend.mapper;

import com.routeRider.backend.domain.StopTimes;
import com.routeRider.backend.domain.Stops;
import com.routeRider.backend.dto.StopsDTO;
import com.routeRider.backend.dto.StopsTimesDTO;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class StopsMapper {

    public static StopsDTO toDto(Stops stops) {
        LocalTime now = LocalTime.now();

        List<StopTimes> stopTimesList = stops.getStopTimes().stream()
                .filter(st -> st.getArrivalTime() != null)
                .sorted(Comparator.comparing(StopTimes::getArrivalTime))
                .collect(Collectors.toList());

        // Get the latest time before now (past)
        Optional<StopTimes> pastTime = stopTimesList.stream()
                .filter(st -> st.getArrivalTime().isBefore(now))
                .reduce((first, second) -> second); // Get the last one before now

        // Get the next two times
        List<StopTimes> upcomingTimes = stopTimesList.stream()
                .filter(st -> !st.getArrivalTime().isBefore(now))
                .limit(2)
                .collect(Collectors.toList());

        // Combine past + next two
        List<StopTimes> closestTimes = new ArrayList<>();
        pastTime.ifPresent(closestTimes::add);
        closestTimes.addAll(upcomingTimes);

        // Now map these to StopsTimesDTO
        List<StopsTimesDTO> stopsTimesDTOS = closestTimes.stream()
                .map(st -> new StopsTimesDTO(
                        st.getArrivalTime().toString(),
                        st.getDepartureTime().toString()
                ))
                .collect(Collectors.toList());

        return new StopsDTO(
                stops.getStop_id(),
                stops.getStopName(),
                stops.getStopDesc(),
                stops.getStopLat(),
                stops.getStopLon(),
                stops.getStopUrl(),
                stopsTimesDTOS
        );
    }
}

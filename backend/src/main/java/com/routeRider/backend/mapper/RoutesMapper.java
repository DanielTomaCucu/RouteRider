package com.routeRider.backend.mapper;

import com.routeRider.backend.domain.Routes;
import com.routeRider.backend.dto.RoutesDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoutesMapper {

    /**
     * Converts a Routes entity to a RoutesDTO object
     *
     * @param routes The Routes entity to convert
     * @return The corresponding RoutesDTO object, or null if the input is null
     */
    public static RoutesDTO toDTO(Routes routes) {
        if (routes == null) {
            return null;
        }

        RoutesDTO routesDTO = new RoutesDTO();
        routesDTO.setRouteId(routes.getRouteId());
        routesDTO.setRouteShortName(routes.getRouteShortName());
        routesDTO.setRouteLongName(routes.getRouteLongName());
        routesDTO.setRouteDescription(routes.getRouteDesc());
        routesDTO.setRouteColor(routes.getRouteColor());
        routesDTO.setRouteTextColor(routes.getRouteTextColor());
        return routesDTO;
    }

    /**
     * Converts a RoutesDTO object to a Routes entity
     *
     * @param routesDTO The RoutesDTO to convert
     * @return The corresponding Routes entity, or null if the input is null
     */
    public static Routes toEntity(RoutesDTO routesDTO) {
        if (routesDTO == null) {
            return null;
        }

        Routes routes = new Routes();
        routes.setRouteId(routesDTO.getRouteId());
        routes.setRouteShortName(routesDTO.getRouteShortName());
        routes.setRouteLongName(routesDTO.getRouteLongName());
        routes.setRouteDesc(routesDTO.getRouteDescription());
        routes.setRouteColor(routesDTO.getRouteColor());
        routes.setRouteTextColor(routesDTO.getRouteTextColor());
        return routes;
    }

    /**
     * Converts a list of Routes entities to a list of RoutesDTO objects
     *
     * @param routesList The list of Routes entities to convert
     * @return The corresponding list of RoutesDTO objects
     */
    public static List<RoutesDTO> toDTOList(List<Routes> routesList) {
        if (routesList == null) {
            return null;
        }

        return routesList.stream()
                .map(RoutesMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Converts a list of RoutesDTO objects to a list of Routes entities
     *
     * @param routesDTOList The list of RoutesDTO objects to convert
     * @return The corresponding list of Routes entities
     */
    public static List<Routes> toEntityList(List<RoutesDTO> routesDTOList) {
        if (routesDTOList == null) {
            return null;
        }

        return routesDTOList.stream()
                .map(RoutesMapper::toEntity)
                .collect(Collectors.toList());
    }
}

package com.routeRider.backend.service;

import com.routeRider.backend.dto.RoutesDTO;
import com.routeRider.backend.mapper.RoutesMapper;
import com.routeRider.backend.repository.RoutesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutsService {

    private final RoutesRepository routesRepository;

    public List<RoutesDTO> getAllRoutes() {
        return RoutesMapper.toDTOList(routesRepository.findAll());
    }

}

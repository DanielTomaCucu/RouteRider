package com.routeRider.backend.repository;

import com.routeRider.backend.domain.Routes;
import com.routeRider.backend.domain.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripsRepository extends JpaRepository<Trips, Integer> {
    List<Trips> findByRoute(Routes route);
}


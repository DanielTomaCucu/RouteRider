package com.routeRider.backend.repository;

import com.routeRider.backend.domain.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.RouteMatcher;

@Repository
public interface RoutesRepository extends JpaRepository<Routes, Integer> {
}

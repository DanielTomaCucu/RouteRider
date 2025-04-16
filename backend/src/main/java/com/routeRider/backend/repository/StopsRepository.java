package com.routeRider.backend.repository;

import com.routeRider.backend.domain.Stops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopsRepository extends JpaRepository<Stops, Integer> {
}

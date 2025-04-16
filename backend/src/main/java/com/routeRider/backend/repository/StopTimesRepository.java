package com.routeRider.backend.repository;

import com.routeRider.backend.domain.StopTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopTimesRepository extends JpaRepository<StopTimes, Integer> {
}

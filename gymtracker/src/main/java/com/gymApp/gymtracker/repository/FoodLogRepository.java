package com.gymApp.gymtracker.repository;

import com.example.gymtracker.model.FoodLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodLogRepository extends JpaRepository<FoodLog, Long> {

    // Find all food logs for a particular user
    List<FoodLog> findByUserId(Long userId);

    // Find a specific food log by ID
    Optional<FoodLog> findById(Long id);
}

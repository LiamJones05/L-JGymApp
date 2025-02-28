package com.gymApp.gymtracker.repository;

import com.yourcompany.gymtracker.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}

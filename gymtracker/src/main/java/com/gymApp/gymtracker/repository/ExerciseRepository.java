package com.gymApp.gymtracker.repository;

import com.yourcompany.gymtracker.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    // You can define custom query methods here if needed
    // For example, to find exercises by workout:
    // List<Exercise> findByWorkoutId(Long workoutId);
}

package com.gymApp.gymtracker.service;

import com.yourcompany.gymtracker.model.Exercise;
import com.yourcompany.gymtracker.model.ExerciseSet;
import com.yourcompany.gymtracker.model.Workout;
import com.yourcompany.gymtracker.repository.ExerciseRepository;
import com.yourcompany.gymtracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    // Save a new workout along with exercises and their sets
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    // Get a workout by its ID
    public Optional<Workout> getWorkout(Long id) {
        return workoutRepository.findById(id);
    }

    // Add a new exercise to a workout
    public Exercise addExerciseToWorkout(Long workoutId, Exercise exercise) {
        Optional<Workout> workout = workoutRepository.findById(workoutId);
        if (workout.isPresent()) {
            exercise.setWorkout(workout.get());
            return exerciseRepository.save(exercise);
        } else {
            throw new IllegalArgumentException("Workout with ID " + workoutId + " not found");
        }
    }

    // Add a new set to an exercise
    public ExerciseSet addSetToExercise(Long exerciseId, ExerciseSet exerciseSet) {
        Optional<Exercise> exercise = exerciseRepository.findById(exerciseId);
        if (exercise.isPresent()) {
            exerciseSet.setExercise(exercise.get());
            return exerciseSet;
        } else {
            throw new IllegalArgumentException("Exercise with ID " + exerciseId + " not found");
        }
    }

    // Get all exercises for a workout
    public List<Exercise> getExercisesForWorkout(Long workoutId) {
        Optional<Workout> workout = workoutRepository.findById(workoutId);
        return workout.isPresent() ? workout.get().getExercises() : null;
    }

    // Example method to calculate total workout duration
    public int calculateWorkoutDuration(Workout workout) {
        // Calculate total workout duration based on exercise duration or other parameters
        return 60; // Just an example, implement logic as needed
    }
}

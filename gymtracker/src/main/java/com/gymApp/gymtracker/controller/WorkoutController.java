package com.gymApp.gymtracker.controller;

import com.yourcompany.gymtracker.model.Workout;
import com.yourcompany.gymtracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.saveWorkout(workout);
    }

    @GetMapping("/{id}")
    public Workout getWorkout(@PathVariable Long id) {
        return workoutService.getWorkout(id);
    }
}

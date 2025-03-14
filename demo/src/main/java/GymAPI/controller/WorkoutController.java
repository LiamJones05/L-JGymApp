package GymAPI.controller;

import GymAPI.model.Workout;
import GymAPI.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;

    // ------------------- GET -----------------------

    // Get all workouts
    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    // Get a workout by ID
    @GetMapping("/{id}")
    public Workout getWorkoutByID(@PathVariable Long id) {
        return workoutRepository.findById(id).orElse(null);
    }

    // Get workouts by user ID
    @GetMapping("/user/{userID}")
    public List<Workout> getWorkoutsByuser_id(@PathVariable Long user_id) {
        return workoutRepository.findByUserId(user_id);
    }

    // ------------------- POST -----------------------

    // Create new workout
    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        if(workout.getWorkoutName()==null){
            throw new RuntimeException("Workout name cannot be null");
        }
        return workoutRepository.save(workout);
    }

    // ------------------- PUT -----------------------

    // Update workout by ID
    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id, @RequestBody Workout updateWorkout) {
        Optional<Workout> optionalWorkout = workoutRepository.findById(id);
        if (optionalWorkout.isPresent()) {
            Workout existingWorkout = optionalWorkout.get();
            existingWorkout.setWorkoutName(updateWorkout.getWorkoutName());
            existingWorkout.setWorkoutDate(updateWorkout.getWorkoutDate());
            return workoutRepository.save(existingWorkout);
        } else {
            return null;
        }
    }

    // ------------------- DELETE -----------------------

    // Delete workout by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkout(@PathVariable Long id) {
        workoutRepository.deleteById(id);
        return ResponseEntity.ok("Workout has been deleted");
    }

    // Delete all workouts by user ID
    @DeleteMapping("/user/{user_id}")
    public ResponseEntity<String> deleteWorkoutByUserID(@PathVariable Long user_id) {
        workoutRepository.deleteByUserId(user_id);
        return ResponseEntity.ok("All workouts for user " + user_id + " have been deleted");
    }
}

package GymAPI.controller;

import GymAPI.model.Workout;
import GymAPI.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Mark class as a REST controller
@RestController
@RequestMapping("/api/workouts")
public class WorkoutController{
    @Autowired
    private WorkoutRepository workoutRepository;

    /*------------GET---------------- */
    @GetMapping // /api/workouts get all workouts from data with URL
    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    @GetMapping("/{id}") // /api/workouts/{id} -> get a workout by id with URL
    public Workout getWorkoutByID(@PathVariable Long id){
        return workoutRepository.findById(id).orElse(null);
    }

    @GetMapping("/user{userID}")

    /*---------------POST--------------- */
    @PostMapping //Create new workout with url /api/workouts
    public Workout createWorkout(@RequestBody Workout workout){
        return workoutRepository.save(workout);
    }

    /*------------------PUT---------------------- */
    //Update an existing workout
    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id, @RequestBody Workout updateWorkout){
        Optional<Workout> optionalWorkout = workoutRepository.findById(id);
        if(optionalWorkout.isPresent()){
            Workout existingwWorkout = optionalWorkout.get();
            existingwWorkout.setWorkoutName(updateWorkout.getWorkoutName());
            existingwWorkout.setWorkoutDate(updateWorkout.getWorkoutDate());

            return workoutRepository.save(existingwWorkout);
        } else{
            return null;
        }
    }
    
    /*---------------DELETE--------------- */
    //Delete workout by ID with url /api/workouts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkout(@PathVariable Long id){
        workoutRepository.deleteById(id);
        return ResponseEntity.ok("Workout has been deleted");
    }

    //Delete all workouts from an associated user
    @DeleteMapping("/user/{userID}")
    public ResponseEntity<String> deleteWorkoutByUserID(@PathVariable Long userID){
        workoutRepository.deleteByUserID(userID);
        return ResponseEntity.ok("All workouts have been deleted");
    }

}
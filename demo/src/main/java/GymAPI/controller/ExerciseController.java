package GymAPI.controller;

import GymAPI.model.Exercise;
import GymAPI.repository.ExerciseRepository;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Mark class as REST controller
@RestController
@RequestMapping("/api/exercise")
public class ExerciseController{
    @Autowired
    private GymAPI.repository.ExerciseRepository exerciseRepository;

    /*---------------GET------------- */
    @GetMapping//get all exercises
    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }
    //Get exercise by ID
    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long id){
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        return exercise.map(ResponseEntity::ok)
        .orElseGet(()->ResponseEntity.notFound().build());
    }

    //Get exercise by workoutId
    @GetMapping("/workout/{workoutId}")
    public List<Exercise> getExercisesByWorkoutId(@PathVariable Long workoutId){
        return exerciseRepository.findByWorkoutId(workoutId);
    }

    /*------------------POST--------------------- */
    //create a new exercise
    @PostMapping
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    /*-----------------PUT---------------*/
    //update an existing exercise
    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise updatedExercise) {
        Optional<Exercise> existingExercise = exerciseRepository.findById(id);
        if (existingExercise.isPresent()) {
            Exercise exercise = existingExercise.get();
            exercise.setExerciseName(updatedExercise.getExerciseName());
            exercise.setWorkoutId(updatedExercise.getWorkoutId());
            exerciseRepository.save(exercise);
            return ResponseEntity.ok(exercise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*-----------------DELETE-------------- */
    //delete an exercise
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        if (exerciseRepository.existsById(id)) {
            exerciseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //delete all exercises with a given WorkoutId
    @DeleteMapping("/workout/{workoutId}")
    public ResponseEntity<Void> deleteExercisesByWorkoutId(@PathVariable Long workoutId){
        exerciseRepository.deleteByWorkoutId(workoutId);
        return ResponseEntity.noContent().build();
    }

}
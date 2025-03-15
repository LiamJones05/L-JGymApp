package GymAPI.controller;

import GymAPI.model.ExerciseSet;
import GymAPI.repository.ExerciseSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sets")
public class ExerciseSetController {

    @Autowired
    private ExerciseSetRepository exerciseSetRepository;

    // GET all sets
    @GetMapping
    public List<ExerciseSet> getAllSets() {
        return exerciseSetRepository.findAll();
    }

    // GET sets by exerciseId
    @GetMapping("/exercise/{exerciseId}")
    public List<ExerciseSet> getSetsByExerciseId(@PathVariable Long exerciseId) {
        return exerciseSetRepository.findByExerciseId(exerciseId);
    }

    // GET set by setId
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseSet> getSetById(@PathVariable Long id) {
        Optional<ExerciseSet> set = exerciseSetRepository.findById(id);
        return set.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST create set
    @PostMapping
    public ExerciseSet createSet(@RequestBody ExerciseSet exerciseSet) {
        return exerciseSetRepository.save(exerciseSet);
    }

    // PUT update set
    @PutMapping("/{id}")
    public ResponseEntity<ExerciseSet> updateSet(@PathVariable Long id, @RequestBody ExerciseSet updatedSet) {
        Optional<ExerciseSet> existingSet = exerciseSetRepository.findById(id);
        if (existingSet.isPresent()) {
            ExerciseSet set = existingSet.get();
            set.setExerciseId(updatedSet.getExerciseId());
            set.setReps(updatedSet.getReps());
            set.setWeight(updatedSet.getWeight());
            exerciseSetRepository.save(set);
            return ResponseEntity.ok(set);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE set by setId
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSetById(@PathVariable Long id) {
        if (exerciseSetRepository.existsById(id)) {
            exerciseSetRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE all sets by exerciseId
    @DeleteMapping("/exercise/{exerciseId}")
    public ResponseEntity<Void> deleteSetsByExerciseId(@PathVariable Long exerciseId) {
        exerciseSetRepository.deleteByExerciseId(exerciseId);
        return ResponseEntity.noContent().build();
    }
}

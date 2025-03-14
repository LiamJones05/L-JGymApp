package GymAPI.repository;

import GymAPI.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    // Corrected method names
    List<Workout> findByUserId(Long userId);  // Correct method name to match userId field
    void deleteByUserId(Long userId);         // Correct method name to match userId field
}

package GymAPI.repository;

import GymAPI.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{
    List<Workout> findByUserID(Long userID);
    void deleteByUserID(Long userID);
}
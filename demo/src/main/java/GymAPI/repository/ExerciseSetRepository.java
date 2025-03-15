package GymAPI.repository;

import GymAPI.model.ExerciseSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {
    List<ExerciseSet> findByExerciseId(Long exerciseId);
    void deleteByExerciseId(Long exerciseId);
}

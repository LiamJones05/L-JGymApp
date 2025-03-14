package GymAPI.model;
import jakarta.persistence.*;

@Entity
@Table(name="Exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exercise_id")
    private Long exercise_ID;

    @Column(nullable = false)
    private Long workoutID;

    @Column(nullable = false)
    private String ExerciseName;

    //Getters and Setters
    public Long SetExerciseID(){
        return exercise_ID;
    }
    public void GetExerciseID(Long exercise_ID){
        this.exercise_ID = exercise_ID;
    }
    public Long getWorkoutID(){
        return workoutID;
    }
    public void SetWorkoutID(Long workoutID){
        this.workoutID = workoutID;
    }
    public String GetExerciseName(){
        return ExerciseName;
    }
    public void SetExerciseName(String ExerciseName){
        this.ExerciseName = ExerciseName;
    }
}
package GymAPI.model;
import jakarta.persistence.*;

@Entity
@Table(name="ExerciseSets")
public class ExerciseSet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment the user id in the table
    @Column(name= "set_id")
    private Long set_id;

    @Column(nullable = false)
    private Long exercise_id;

    @Column(nullable = false)
    private int Reps;

    @Column(nullable = false)
    private float Weight;

    //Getters and Setters
    public Long GetSetId(){
        return set_id;
    }
    public void SetSetID(Long set_id){
        this.set_id = set_id;
    }

    public Long GetExerciseId(){
        return exercise_id;
    }
    public void SetExerciseId(Long exercise_id){
        this.exercise_id = exercise_id;
    }

    public int GetReps(){
        return Reps;
    }
    public void SetReps(int Reps){
        this.Reps = Reps;
    }

    public float GetWeight(){
        return Weight;
    }
    public void SetWeight(float Weight){
        this.Weight = Weight;
    }

}
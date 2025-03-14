package GymAPI.model;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Workouts")
public class Workout{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment workout id in the table
    private Long workout_id;

    @Column(nullable =false)
    private Long userID;

    @Column(nullable = false)
    private String workout_name;

    @Column(nullable = false)
    private Date workout_date;


    //Getters and setters-----------
    public Long getWorkoutId(){
        return workout_id;
    }

    public void SetWorkoutID(Long workout_id){
        this.workout_id = workout_id;
    }

    public Long GetUserID(){
        return userID;
    }
    public void setUserId(Long userID){
        this.userID = userID;
    }

    public String GetWorkoutName(){
        return workout_name;
    }
    public void SetWorkoutName(String workout_name){
        this.workout_name = workout_name;
    }

    public Date GetWorkoutDate(){
        return workout_date;
    }
    public void SetWorkoutDate(Date workout_date){
        this.workout_date = workout_date;
    }

}
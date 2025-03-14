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
    
    public void setWorkoutId(Long workout_id){
        this.workout_id = workout_id;
    }
    
    public Long getUserId(){
        return userID;
    }
    public void setUserId(Long userID){
        this.userID = userID;
    }
    
    public String getWorkoutName(){
        return workout_name;
    }
    public void setWorkoutName(String workout_name){
        this.workout_name = workout_name;
    }
    
    public Date getWorkoutDate(){
        return workout_date;
    }
    public void setWorkoutDate(Date workout_date){
        this.workout_date = workout_date;
    }

}
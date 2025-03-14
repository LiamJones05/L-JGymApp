package GymAPI.model;
import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Workouts")
public class Workout{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment workout id in the table
    private Long workout_id;

    @Column(nullable =false)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate workout_date;


    //Getters and setters-----------
    public Long getWorkoutId(){
        return workout_id;
    }
    
    public void setWorkoutId(Long workout_id){
        this.workout_id = workout_id;
    }
    
    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userID){
        this.userId = userID;
    }
    
    public String getWorkoutName(){
        return name;
    }
    public void setWorkoutName(String workout_name){
        this.name = workout_name;
    }
    
    public LocalDate getWorkoutDate(){
        return workout_date;
    }
    public void setWorkoutDate(LocalDate workout_date){
        this.workout_date = workout_date;
    }

}
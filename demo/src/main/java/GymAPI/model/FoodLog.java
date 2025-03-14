package GymAPI.model;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name="FoodLogs")
public class FoodLog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="food_log_id")
    private Long FoodLogID;

    @Column(nullable = false)
    private Long UserID;

    @Column(nullable = false)
    private String FoodName;

    @Column(nullable = false)
    private int Calories;

    @Column(nullable = false)
    private int Fats;

    @Column(nullable = false)
    private int Carbs;

    @Column(nullable = false)
    private int Protein;

    @Column(nullable = false)
    private Date FoodLogDate;

    //Getters and Setters
    public Long getFoodLogId(){
        return FoodLogID;
    }
    public void SetFoodLogId(Long FoodLogID){
        this.FoodLogID = FoodLogID;
    }

    public Long GetUserID(){
        return UserID;
    }
    public void SetUserID(Long UserID){
        this.UserID = UserID;
    }
}
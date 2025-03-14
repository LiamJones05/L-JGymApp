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

    public String GetFoodName(){
        return FoodName;
    }
    public void SetFoodName(String Foodname){
        this.FoodName = Foodname;
    }

    public int GetCalories(){
        return Calories;
    }
    public void SetCalories(int Calories){
        this.Calories = Calories;
    }
    public int GetFat(){
        return Fats;
    }
    public void SetFat(int Fats){
        this.Fats = Fats;
    }
    public int GetCarbs(){
        return Carbs;
    }
    public void SetCarbs(int Carbs){
        this.Carbs=Carbs;
    }
    public int GetProtein(){
        return Protein;
    }
    public void SetProtein(int Protein){
        this.Protein = Protein;
    }
    public Date GetFoodLogDate(){
        return FoodLogDate;
    }
    public void SetFoodLogDate(Date FoodLogDate){
        this.FoodLogDate = FoodLogDate;
    }
}
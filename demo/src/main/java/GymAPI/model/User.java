package GymAPI.model;
import jakarta.persistence.*;

@Entity
@Table(name="UserTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment the user id in the table
    @Column(name= "user_id")
    private Long userId;

    @Column(nullable = false, unique = true)//email must be present and unique
    private String email;

    @Column(nullable = false) //password must be present
    private String password;


    //Getter and setter for user ID
    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    //Getter and setter for email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    //Getter and setter for password
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

}

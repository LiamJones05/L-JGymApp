package GymAPI.controller;

import GymAPI.model.User;
import GymAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Mark class as a REST controller
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    /*--------------GET--------------- */

    @GetMapping // /api/users -> get all users from database with URL
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}") //Get /api/users/{id} -> get a user by a specific ID with URL
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    /*-----------POST--------------*/
    @PostMapping //Create new user with url /api/users
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    /*----------------PUT-------------- */
    //Update Existing user data
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updateUser){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            existingUser.setEmail(updateUser.getEmail());
            existingUser.setPassword(updateUser.getPassword());
            return userRepository.save(existingUser);
        } else{
            return null; //user not found
        }
    }

    /*--------------DELETE------------- */
    //Delete a user by ID with url /api/users/{id}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}

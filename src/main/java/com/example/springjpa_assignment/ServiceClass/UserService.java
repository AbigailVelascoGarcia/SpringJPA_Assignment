package com.example.springjpa_assignment.ServiceClass;

import com.example.springjpa_assignment.Entity.User;
import com.example.springjpa_assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void createUser(User user){
        if (userRepo.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("Users with that email already exists :-/");
        }
        userRepo.save(user);
    }

    public void updateUser(User user, String email, String area_of_interest){
        if(email != null){
            user.setEmail(email);
        }
        if (area_of_interest != null){
            user.setArea_of_interest(area_of_interest);
        }
        userRepo.save(user);
    }

    public void deleteUser(int user_id){
        User user = userRepo.findById(user_id).get();
        try{
            userRepo.delete(user);
        } catch(Exception e){
            throw new IllegalArgumentException("User not found");
        }
    }
    public List<User> getAllUsers(){

        return (List<User>) userRepo.findAll();
    }

    public User getUserbyName(String name){
        return userRepo.findByName(name);
    }

    public User getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }
}

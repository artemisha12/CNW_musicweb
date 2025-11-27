package com.music.service;


import com.music.model.bean.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
   
    private static List<User> mockUsers = new ArrayList<>();
    private static int autoId = 1;

    static {
      
        mockUsers.add(new User(autoId++, "admin", "123456", "admin")); 
        mockUsers.add(new User(autoId++, "user", "123456", "user"));
    }

  
    public User checkLogin(String username, String password) {
        for (User u : mockUsers) {
            
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u; 
            }
        }
        return null; 
    }

    public boolean isUsernameExist(String username) {
        for (User u : mockUsers) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

   
    public boolean register(String username, String password) {
        if (isUsernameExist(username)) {
            return false; 
        }
       
        User newUser = new User(autoId++, username, password, "user");
        mockUsers.add(newUser);
        return true;
    }
}
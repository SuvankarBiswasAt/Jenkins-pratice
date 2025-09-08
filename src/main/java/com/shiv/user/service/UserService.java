package com.shiv.user.service;

import com.shiv.user.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public List<User> findAll(){
        return users;
    }

    public User findById(Integer Id){
        return users.stream()
                .filter(user -> Objects.equals(user.getUserId(), Id))
                .findFirst().orElse(null);
    }

    public boolean addUser(User user){
        User existingUser = getUser(user);
        if(existingUser == null){
            user.setUserId(users.size()+1);
            user.setUserUUID(String.valueOf(UUID.randomUUID()));
            users.add(user);
            return true;
        }
        return false;
    }

    public boolean updateUser(User user){
        User existingUser = getUser(user);
        if(existingUser != null){
            existingUser.setUserName(user.getUserName());
            return true;
        }
        return false;
    }

    private User getUser(User user) {
        for (User data: users){
            if(user.getUserUUID().equals(data.getUserUUID()))
                return data;
        }
        return null;
    }

    public boolean deleteUser(User user){
        User existingUser = getUser(user);
        if(existingUser != null){
            users.remove(existingUser);
            return true;
        }
        return false;
    }

}

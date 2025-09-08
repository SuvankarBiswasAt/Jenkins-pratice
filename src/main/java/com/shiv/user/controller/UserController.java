package com.shiv.user.controller;

import com.shiv.user.model.User;
import com.shiv.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") Integer Id){
        return userService.findById(Id);
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

}

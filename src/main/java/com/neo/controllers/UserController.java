package com.neo.controllers;

import com.neo.dao.UserDAO;
import com.neo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/list")
    public List<User> getData(){
        return userDAO.findAll();
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public User postData(@RequestBody User user){
        return userDAO.save(user);
    }
}

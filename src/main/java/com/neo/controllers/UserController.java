package com.neo.controllers;

import com.neo.dao.UserDAO;
import com.neo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
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
    public User postData(@RequestBody User userObj, String deptObj){
        log.debug("deptname="+deptObj);
        return userDAO.save(userObj);
    }

    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable(value = "id") Long id){
        userDAO.delete(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public User updateData(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails){
        User user = userDAO.findById(id);
        if (user==null){
            log.debug("user not found");
        }

        user.setName(userDetails.getName());
        user.setMobile(userDetails.getMobile());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setStatus(userDetails.getStatus());
        return user;
    }
}

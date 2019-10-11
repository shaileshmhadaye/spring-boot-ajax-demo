package com.neo.controllers;

import com.neo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("user/add")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "add";
    }

    @RequestMapping("/departments")
    public String dept(){
        return "departments";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

}

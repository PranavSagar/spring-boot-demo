package com.springTest.springbootdemo.controller;

import com.springTest.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    //we will give address for request
    @RequestMapping("")
    public String home(){
        return "hello";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
//    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setId("10");
        user.setEmailId("raj@gmail.com");
        user.setName("Raj");

        return user;
    }
    @GetMapping("/{id}/{val}")
    public String pathVariable(@PathVariable String id, @PathVariable int val){
        return " The Path Variable is " + id +" "+ val;
    }
}

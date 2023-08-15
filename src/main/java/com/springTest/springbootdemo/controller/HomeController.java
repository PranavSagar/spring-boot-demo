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

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name ,@RequestParam(name = "email",required = false,defaultValue = "") String emailId ){ // required = true is default then you have to put emailId in URL
        return "Your name is "+ name +" and email id is "+ emailId;  //http://localhost:8080/requestParam?name=raj&emailId=raj@gmail.com
    }
    //[ ------------------FOR ABOVE -----------------]
    //The code you've provided contains two different methods that handle different types of request parameters in Spring Framework's web applications.
    //
    //@GetMapping("/{id}/{val}") - Path Variables:
    //
    //This method uses the @PathVariable annotation to extract values from the URI path. In this case, the method has two path variables {id} and {val}.
    // When a request is made to a URL like /something/42, the values something and 42 would be extracted and passed to the method's parameters id and val, respectively. For example:
    //
    //URL: /myPath/123/456
    //Method call: pathVariable("myPath", 123)
    //The method then constructs a response using these variables.
    //
    //@GetMapping("/requestParam") - Request Parameters:
    //
    //This method uses the @RequestParam annotation to retrieve query parameters from the URL. Query parameters are key-value pairs added to the URL after the question mark ?, like ?name=value.
    // The method's parameters name and emailId are mapped to these query parameters. The @RequestParam annotation also allows specifying optional parameters, default values, and whether a parameter is required.
    //
    //For example, given the URL: http://localhost:8080/requestParam?name=raj&emailId=raj@gmail.com
    //
    //name parameter value: "raj"
    //emailId parameter value: "raj@gmail.com"
    //If the URL was missing the emailId parameter, the method would still work because it has a default value of an empty string and is not marked as required.
//    In summary, the first method extracts values from the URI path, while the second method retrieves query parameters from the URL.
//    The choice between using path variables and request parameters depends on the way you want to structure your URLs and the kind of data you want to pass to your methods.





}

package com.laide.SpringSecurity.controller;

import com.laide.SpringSecurity.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public ResponseEntity<List<User>> listUser(){
        return new ResponseEntity<>(getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listUser(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(getUsers().stream().filter(user -> user.getId()
                .equals(id)).findFirst().orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> listUser(@RequestBody User user){
        return new ResponseEntity<String>("18", HttpStatus.OK);
    }


    private List<User> getUsers() {
        User user = new User();
        user.setId("12");
        user.setEmail("johndoe123@gmail.com");
        user.setName("John Doe");
        user.setAddress("Bangalore, Karnataka");
        User user1 = new User();
        user1.setId("13");
        user1.setEmail("amitsingh@yahoo.com");
        user1.setName("Amit Singh");
        user1.setAddress("Chennai, Tamilnadu");
        User user2 = new User();
        user2.setId("14");
        user2.setEmail("bipulkumar@gmail.com");
        user2.setName("Bipul Kumar");
        user2.setAddress("Bangalore, Karnataka");
        User user3 = new User();
        user3.setId("15");
        user3.setEmail("prakashranjan@gmail.com");
        user3.setName("Prakash Ranjan");
        user3.setAddress("Chennai, Tamilnadu");
        return Arrays.asList(user, user1, user2, user3);
    }
}

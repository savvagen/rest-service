package com.example;


import com.example.Objects.User;
import com.example.jakson.Status;
import com.example.jakson.TestUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class UserController {


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "id") Integer id){
        User user = new User(id, "Savva", "Genchevskiy", "test@gmail.com");
        return user;
    }



    @RequestMapping(value = "/user", method = RequestMethod.GET)
    User[] getUsers(){
        User[] users = new User[2];
        User user1 = new User(1, "Savva", "Genchevskiy", "test@gmail.com");
        User user2 = new User(2, "Savva", "Genchevskiy", "test@gmail.com");
        users[0] = user1;
        users[1] = user2;
        return users;
    }



    // JAKSON ANNOTATIONS
    @RequestMapping(value = "/testUser/{id}", method = RequestMethod.GET)
    public TestUser getTestUser(@PathVariable(value = "id") Integer id){
        TestUser user = new TestUser(id, "Savva", "Genchevskiy", "test@gmail.com");
        return user;
    }


    @RequestMapping(value = "/testUser/status/{id}", method = RequestMethod.GET)
    public Status getTestUserQuote(@PathVariable(value = "id") Integer id){
        Status status = new Status();
        TestUser user = new TestUser(id, "Savva", "Genchevskiy", "test@gmail.com");
        if (user.getId() == 1){
            status.setStatus("exist");
            status.setValue(user);
        } else {
            status.setStatus("false");
        }
        return status;
    }






























}

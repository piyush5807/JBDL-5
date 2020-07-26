package org.geeksforgeeks.jbdl.jbdl5springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
public class UserController {

//    @Autowired
//    private User my_user;

    @Autowired
    MyConfig my_config;

    @Autowired
    UserService service;

    @GetMapping("/users")
    public User getUser(){
        User my_user = my_config.getUser();
        my_user.setAge(20);
        my_user.setName("ABC");
        System.out.println(my_user);
        return my_user;
    }

//    @GetMapping("/users2")
//
//    public User getUser2(){
//        return new User(20, "ABC");
//    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void getUserPost(@RequestBody List<User> users){
        System.out.println(users);

        service.insert(users);
    }
}


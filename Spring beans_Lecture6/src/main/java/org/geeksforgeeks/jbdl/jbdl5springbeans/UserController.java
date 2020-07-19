package org.geeksforgeeks.jbdl.jbdl5springbeans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    int count;

    public UserController(int count) {
        this.count = count;
    }

    public UserController(){
    }

    @GetMapping("/users")
    @ResponseBody
    public User getUser(){
        return new User(21, "XYZ");
    }

    @GetMapping("/users2")

    public User getUser2(){
        return new User(20, "ABC");
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void getUserPost(@RequestBody User user){
        System.out.println(user);
    }
}


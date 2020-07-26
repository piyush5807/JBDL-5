package org.geeksforgeeks.jbdl.jbdl5springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User2Controller {

//    @Autowired
//    private User user2;

    @Autowired
    MyConfig config2;

    @GetMapping("/users2")
    public User getUser(){
        User user2 = config2.getUser();
        user2.setAge(30);
        user2.setName("DEF");
        System.out.println(user2);
        return user2;
    }
}

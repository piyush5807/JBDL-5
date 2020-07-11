package com.example.MyApp5;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class Controller {

    DB db = new DB();
    @GetMapping("/hi")
    public String sayHello(){
        return "Hello Coders";
    }
    // USD TO INR - Get

    // https://www.google.com/search?q=sachin
    // http://localhost:8090/usd_to_inr?q=5
    @GetMapping("/usd_to_inr")
    public int convertToINR(@RequestParam int q){
        int usd = q;
        return 75*usd;
    }

    @GetMapping("/user")
    public User getAUser(){
        User user = new User(1,"Raka",25);
        return user;
    }
    // Create a new User  - POST
    @PostMapping("/users")
    public boolean createAUser(@RequestBody User user){
        return db.addAUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return db.getAllUsers();
    }
    // search a user by user_id

    // http://localhost:8090/search/users?id=101  - Query Param
    // http://localhost:8090/search/users/101      - Path Param
    @GetMapping("/search/users")
    public User findAUser(@RequestParam int id){
        return db.findAUser(id);
    }

    // http://localhost:8090/search/users?id=101  - Query Param
    // http://localhost:8090/search/users/101      -Path Param
    @GetMapping("/search/users/{id}")
    public User findAUserUsingPathParam(@PathVariable int id){
        return db.findAUser(id);
    }

    @PutMapping("/users")
    public boolean updateAUser(@RequestBody User user){
        return db.updateAUser(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id){
        return db.deleteAUser(id);

    }









}

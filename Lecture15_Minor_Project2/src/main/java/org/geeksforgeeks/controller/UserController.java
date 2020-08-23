//package org.geeksforgeeks.controller;
//
//import org.geeksforgeeks.dao.UserRepository;
//import org.geeksforgeeks.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @RequestMapping(value="/user", method = RequestMethod.GET)
//    public List<User> listUser(){
//        return userRepository.findAll();
//
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public User create(@RequestBody User user){
//        return userService.save(user);
//    }
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable(value = "id") Long id){
//        userService.delete(id);
//        return "success";
//    }
//
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public void signup(@RequestBody User user){
//        System.out.println("hello");
//    }
//
//}

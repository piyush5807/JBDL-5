package org.geeksforgeeks.jbdl5.demospringsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/student")
    public String getStudent(){
        return "This is a student responding";
    }

    @GetMapping("/faculty")
    public String getFaculty(){
        return "This is a faculty responding";
    }

    @GetMapping("/general")
    public String getGeneral(){
        return "This is a general person responding";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "this is an admin";
    }
}

package org.geeksforgeeks.jbdl5.demospringsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MyController {

    @Autowired
    UserRepository userRepository;
//
//    @Value("${authorities.student}")
//    private String authority_student;

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

    @PostMapping("/signup")
    public void signup(@RequestBody MyUser user){

        String user_name = user.getUsername();

        // if user_name exists in database or not


//        user.setAuthorities(authority_student);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    @GetMapping("/token")
    public void getToken(HttpServletRequest httpServlet){

        Cookie[] cookie_Arr = httpServlet.getCookies();
        String userName = cookie_Arr[0].toString();
        String password = cookie_Arr[1].toString();


        // client -> username password
        // server -> send a token
        // client - token
        // cookie
        // header - data, content-type

        // username and password -> token

    }
}


package com.example.MyApp5;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class Controller {

    DB db = new DB();

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String sayHello2(){
        return "Hello Coders";
    }

    @GetMapping("/hi") // RequestMapping + GET
    public String sayHello(){
        return "Hello Coders on Heroku";
    }
    // USD TO INR - Get

    // https://www.google.com/search?q=sachin
    // http://localhost:8090/usd_to_inr?q=5
    @ApiOperation("This is a converter API")
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
    @PostMapping("/users") // RequestMapping + POST
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

    @GetMapping("/users/v2")
    public ResponseEntity<User> getAUserV2(){

        MultiValueMap<String, String> headers =
                new LinkedMultiValueMap<>();
        headers.put("Server", Collections.singletonList("Shashi-Server"));
        headers.put("anything", Collections.singletonList("something"));
        User responseBody = new User(308,"Vishal",50);
        ResponseEntity<User> response =
                new ResponseEntity<User>(responseBody,headers, HttpStatus.ACCEPTED);
        return response;
    }

    /*
    @PostMapping(value = "/abcd",
            consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })

    public String sayabcd()
    {
        return "say Hello";
    }

     */


    @RequestMapping("/gitHub/users/{login}")
    public ResponseEntity<GitHubUser> get(@PathVariable("login") String login){

        RestTemplate restTemplate = new RestTemplate();
        //https://api.github.com/users/+login
        ResponseEntity<GitHubUser> response =
                restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), GitHubUser.class);

        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        return response;
    }



    /*
    @RequestMapping("/gitHub/users/{login}")
    public ResponseEntity<GitHubUser> get(@PathVariable("login") String login){

        ResponseEntity<GitHubUser> response = restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), GitHubUser.class);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        GitHubUser gitHubUser = response.getBody();
        System.out.println(gitHubUser.toString());
        return response;
    }

     */













    }

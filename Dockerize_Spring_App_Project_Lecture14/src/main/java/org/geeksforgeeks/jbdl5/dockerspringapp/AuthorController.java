package org.geeksforgeeks.jbdl5.dockerspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/docker")
    public String getDocker(){
        return "Hello Docker";
    }

    @PostMapping("/authors")
    public void insertAuthor(@RequestBody Author author){
        authorRepository.save(author);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }
}

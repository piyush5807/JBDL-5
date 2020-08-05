package org.geeksforgeeks.jbdl.jbdl5springbeans;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/book")
    public String getBook(){
        return "I am book in Java";
    }
}

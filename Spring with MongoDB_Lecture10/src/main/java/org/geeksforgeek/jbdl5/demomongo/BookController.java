package org.geeksforgeek.jbdl5.demomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return service.getBooks();
    }

    @GetMapping("/book/{name}")
    public Book getBookByName(@PathVariable String name){
        return service.getBookName(name);
    }

    @PostMapping("/insert")
    public void insertBook(@RequestBody Book book){
        service.insert(book);
    }

    @PostMapping("/bulk/insert")
    public void bulkInsert(@RequestBody List<Book> books){
        service.insertBulk(books);
    }
}

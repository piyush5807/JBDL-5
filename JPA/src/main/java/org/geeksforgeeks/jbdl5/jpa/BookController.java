package org.geeksforgeeks.jbdl5.jpa;

import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void insertBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    @GetMapping("/bookById")
    public Book getBookById(@RequestParam(value = "id") int id){
        Optional<Book> result = bookRepository.findById(id);
        return (Book)result.get();
    }

    @GetMapping("/bookById/{id}")
    public Book getBookByPathParam(@PathVariable int id){
        Optional<Book> result = bookRepository.findById(id);
        return (Book)result.get();
    }

    @PostMapping("/person")
    public void insertPerson(@RequestBody Person p){
        personRepository.save(p);
    }

//    @PutMapping("/person")
//    public Person updatePerson(@RequestBody Person p){
//        personRepository.u
//    }

    @GetMapping("/bookByAuthor")
    public List<Book> getBooksByAuthor(@RequestParam(value = "name") String name){
        return bookRepository.getAuthorBooksSQL(name);
    }

    @GetMapping("/findByPrice")
    public List<Book> getBooksByCost(@RequestParam(value = "cost") int cost){
        List<Book> result = bookRepository.findByPrice(cost);

        if(result != null || result.size() == 0){
            throw new InternalError();
        }

        return result;
    }

}

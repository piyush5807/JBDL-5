package org.geeksforgeek.jbdl5.demomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void insert(Book book){
        bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBookName(String name){
        return bookRepository.findByName(name);
    }

    public void insertBulk(List<Book> books) {
        try {
            bookRepository.saveAll(books);
        }catch (Exception e){
            bookRepository.deleteAll(books);
        }
    }
}

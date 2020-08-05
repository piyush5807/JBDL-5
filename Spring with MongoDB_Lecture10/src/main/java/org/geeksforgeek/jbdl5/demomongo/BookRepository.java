package org.geeksforgeek.jbdl5.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {

    public Book findByName(String name);
}

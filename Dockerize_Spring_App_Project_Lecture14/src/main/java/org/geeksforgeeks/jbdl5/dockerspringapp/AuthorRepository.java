package org.geeksforgeeks.jbdl5.dockerspringapp;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, Long> {

}

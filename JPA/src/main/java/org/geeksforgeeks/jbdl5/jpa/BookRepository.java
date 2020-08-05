package org.geeksforgeeks.jbdl5.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query("select * from books where books.authorName:name")
//    public List<Book> getBooksByAuthor(String name);
//
//
//    @Query("")
//    @Override
//    List<Book> findAll();

//    @Modifying
//    @Query("update person p where p.id=:id AND p.age:=age")
//    public void updatePerson(int id, int age);

    public List<Book> findByAuthorName(String name);

    // JPQL -> Java persistence query language
    @Query("select b from Book b where b.cost=:cost")
    public List<Book> findByCosts(int cost);

    // SQL
    @Query(value = "select * from Book b where b.cost=:price", nativeQuery = true)
    public List<Book> findByPrice(int price);

//    @Query("select b from Book b where b.authorName=:name")
//    public List<Book> getAuthorBooksJPQL(String name);

    @Query(value = "select * from Book b where b.authorName=:name", nativeQuery = true)
    public List<Book> getAuthorBooksSQL(String name);

}

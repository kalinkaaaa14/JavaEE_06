package com.example.demo.repository;

import com.example.demo.entity.BookE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface BookRepository extends JpaRepository<BookE, Integer> {

  //  List<BookE> findAll();

    BookE findByIsbn(String isbn);

    @Query("SELECT b FROM BookE b WHERE lower(b.title) LIKE %:search% OR lower(b.author) LIKE %:search% OR lower(b.isbn) LIKE %:search%")
    List<BookE> findAllWhereTitleLikeOrAuthorLikeOrIsbnLike(@Param("search") String search);

}

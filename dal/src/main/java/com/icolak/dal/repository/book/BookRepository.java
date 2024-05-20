package com.icolak.dal.repository.book;

import com.icolak.dal.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByIsbn(String isbn);
}
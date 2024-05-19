package com.icolak.dal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookId;

    String title;

    Integer bookYear;

    String author;

    String pressName;

    String isbn;

    public Book(String title, int bookYear, String author, String pressName, String isbn) {
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
        this.isbn = isbn;
    }
}
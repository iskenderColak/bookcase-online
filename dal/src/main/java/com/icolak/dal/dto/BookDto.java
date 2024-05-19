package com.icolak.dal.dto;

import com.icolak.dal.model.Book;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    BookIdDto bookIdDto;
    String title;
    Integer bookYear;
    String author;
    String pressName;

    public static BookDto convert(Book book) {
        return new BookDto(
                new BookIdDto(
                        book.getBookId(),
                        book.getIsbn()
                ),
                book.getTitle(),
                book.getBookYear(),
                book.getAuthor(),
                book.getPressName()
        );
    }
}
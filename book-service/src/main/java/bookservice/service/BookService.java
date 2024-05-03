package bookservice.service;

import bookservice.dto.BookDto;
import bookservice.dto.BookIdDto;
import bookservice.exception.BookNotFoundException;
import bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
            .map(BookDto::convert)
            .collect(Collectors.toList());
    }

    public BookIdDto findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
            .map(book -> new BookIdDto(book.getBookId(), book.getIsbn()))
            .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: " + isbn));
    }

    public BookDto findBookDetailsById(Integer bookId) {
        return bookRepository.findById(bookId)
            .map(BookDto::convert)
            .orElseThrow(() -> new BookNotFoundException("Book could not found by id: " + bookId));
    }
}
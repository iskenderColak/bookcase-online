package bookservice.controller;

import com.icolak.dal.dto.book.BookDto;
import com.icolak.dal.dto.book.BookIdDto;
import bookservice.service.BookService;
import jakarta.validation.constraints.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/book")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(
            @PathVariable @Size(max = 7, message = "max 7") @NotNull String isbn) {
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @Positive @Max(5) Integer bookId) {
        return ResponseEntity.ok(bookService.findBookDetailsById(bookId));
    }
}
package libraryservice.service;

import com.icolak.dal.dto.library.AddBookRequest;
import com.icolak.dal.dto.library.LibraryDto;
import com.icolak.dal.model.library.Library;
import com.icolak.dal.repository.library.LibraryRepository;
import libraryservice.client.BookServiceClient;
import libraryservice.exception.LibraryNotFoundException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.util.stream.Collectors;

@Slf4j
@Validated
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryService {

    final LibraryRepository libraryRepository;
    final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById(Integer id) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));

        return new LibraryDto(
                library.getId(),
                library.getUserBook()
                        .stream()
                        .map(bookServiceClient::getBookById)
                        .map(ResponseEntity::getBody)
                        .collect(Collectors.toList())
        );
    }

    public LibraryDto createLibrary() {
        Library newLibrary = libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId());
    }

    public void addBookToLibrary(AddBookRequest request) {
        Integer bookId = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();
        Library library = libraryRepository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + request.getId()));

        library.getUserBook().add(bookId);

        libraryRepository.save(library);
    }
}
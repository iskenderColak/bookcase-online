package bookservice;


import com.icolak.dal.model.Book;
import com.icolak.dal.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan({"bookservice", "com.icolak.dal"})
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

    public BookServiceApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("The Lord of the Rings", 1954, "J.R.R. Tolkien", "Allen & Unwin", "abc-123");
		Book book2 = new Book("The Hobbit", 1937, "J.R.R. Tolkien", "Allen & Unwin", "def-456");
		Book book3 = new Book("The Silmarillion", 1977, "J.R.R. Tolkien", "Allen & Unwin", "ghi-789");

		List<Book> bookList = bookRepository.saveAll(Arrays.asList(book1, book2, book3));

		bookList.forEach(System.out::println);
	}
}

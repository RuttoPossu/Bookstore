package hh.backend.bookstore.bookstore;


import hh.backend.bookstore.bookstore.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.bookstore.domain.Book;
import hh.backend.bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookRepository bookRepository) {
		return args -> {
			bookRepository.save(new Book("The Great Gatsby", "F. Scott Fitzgeralt", 1925, "9780333791035", 10.99));
			bookRepository.save(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "9788845292613",  29.99));
			bookRepository.save(new Book("Lord of the Flies", "William Golding", 1954, "9781573226127",  12.99));

			System.out.println("Sample books added to the database");
		};
	}

}

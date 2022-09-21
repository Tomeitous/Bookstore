package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner Demo(BookRepository Repository) { 
		return (args) -> {
			Book b1 = new Book("Kirja1", "Teemu H", "wqefd234", 10);
			Book b2 = new Book("Kirja2", "Matti M", "osdkaodo", 15);
			Repository.save(b1);
			Repository.save(b2);
		};
}
}

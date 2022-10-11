package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner Demo(BookRepository Repository, CategoryRepository drepository){ 
		return (args) -> {
			log.info("save ");
			Category category1 = new Category("Kauhu");
			drepository.save(category1);
			Category category2 = new Category("Komedia");
			drepository.save(category2);
			
			Repository.save(new Book("Seitsemän veljestä", "Aleksis Kivi", "2345-234", 10, category1));
			Repository.save(new Book("Sinuhe Egyptiläinen", "Mika Valtari", "3456-547", 12, category2));
			
			
			
			log.info("lisää kirja");
			for (Book book : Repository.findAll()) {
				log.info(book.toString());
			}
			
		};
		}
	}
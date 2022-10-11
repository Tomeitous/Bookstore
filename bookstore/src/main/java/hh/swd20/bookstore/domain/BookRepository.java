package hh.swd20.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;



//tietokantakäsittelyn rajapinta
public interface BookRepository extends CrudRepository<Book, Long> {
	
	// http://localhost:8080/api/books/search/findByTitle?title=a
	@RestResource
	public List<Book> findByTitle(@Param("title") String title);
	

}

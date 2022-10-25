package hh.swd20.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


public interface BookRepository extends CrudRepository<Book, Long> {

	@RestResource
	public List<Book> findByTitle(@Param("title") String title);
	

}

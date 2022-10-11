package hh.swd20.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findByName(String name);
	

}

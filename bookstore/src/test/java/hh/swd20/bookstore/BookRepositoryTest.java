package hh.swd20.bookstore;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test 
    public void findByTitleShouldReturnBook() {
        List<Book> book = repository.findByTitle("Seitsemän Veljestä");
        
        assertThat(book).hasSize(1);
        assertThat(book.get(0).getAuthor()).isEqualTo("Aleksis Kivi");
    }
    
    
    public void createNewBook() {
    	Book book = new Book("tesikirja", "seppo", "mm@mouse.com", 14, null);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}


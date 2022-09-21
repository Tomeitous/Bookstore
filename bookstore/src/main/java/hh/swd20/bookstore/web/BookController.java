package hh.swd20.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository Repository;
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getCars(Model model) {
			model.addAttribute("book", Repository.findAll()); 
			return "booklist"; 
	}

	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		Repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	    // http://localhost:8080/hello?age=18&name=John
		
	@RequestMapping(value = "/addbook")
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		Repository.save(book);
		return "redirect:/booklist";
	}
	}

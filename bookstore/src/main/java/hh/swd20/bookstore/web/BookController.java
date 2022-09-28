package hh.swd20.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository Repository;
	@Autowired
	private CategoryRepository CRepository;
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
			model.addAttribute("book", Repository.findAll()); 
			return "booklist"; 
	}


	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		Repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@RequestMapping(value = "/addbook")
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", CRepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		Repository.save(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    Book book = Repository.findById(id)
	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	      
	    model.addAttribute("book", book);
		model.addAttribute("categories", CRepository.findAll());
	    
	    return "editbook";
	}
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id,
	  Book book, Model model) {

	    Repository.save(book);
	    return "redirect:/booklist";
	}
	


	}

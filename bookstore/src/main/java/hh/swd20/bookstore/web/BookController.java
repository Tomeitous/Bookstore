package hh.swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
		@GetMapping("/index")
	    public String test(String name, Model model) {

	    	return "index";
	    }

	    // http://localhost:8080/hello?age=18&name=John
	    
	}

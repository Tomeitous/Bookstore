package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;


@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository Repository;
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategory(Model model) {
			model.addAttribute("category", Repository.findAll()); 
			return "categorylist"; 
	}
	
	@RequestMapping(value = "/addcategory")
	public String getNewCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category) {
		Repository.save(category);
		return "redirect:/categorylist";
	}
}

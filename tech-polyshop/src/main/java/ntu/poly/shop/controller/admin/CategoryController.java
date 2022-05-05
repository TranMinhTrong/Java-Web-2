package ntu.poly.shop.controller.admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import ntu.poly.shop.domain.Category;
import ntu.poly.shop.models.CategoryDTO;
import ntu.poly.shop.service.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new CategoryDTO());
		
		return "admin/categories/addOrEdit";
	}

	@GetMapping("edit/{categoryId}")
	public String edit() {
		return "admin/categories/addOrEdit";
	}
	
	@GetMapping("delete/{categoryId}")
	public String delete() {
		return "redirect: /admin/categories";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, CategoryDTO dto) {
		
		Category entity= new Category();
		BeanUtils.copyProperties(dto, entity);
		categoryService.save(entity);
		
		model.addAttribute("message","Category is save!");
		
		return new ModelAndView("redirect:/admin/categories",model);
	}
	
	@GetMapping("")
	public String list(ModelMap model) {
		List<Category> list= categoryService.findAll();
		model.addAttribute("categories",list);
		
		return "admin/categories/list";
		
	}
	@GetMapping("search")
	public String search() {
		return "admin/categories/search";
	}
}

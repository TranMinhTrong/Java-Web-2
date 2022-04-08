package trong.ntu.edy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import trong.ntu.edy.model.Employee;
import trong.ntu.edy.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	//display list of emplyees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1,"firstName","asc",model);
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		
		Employee employee= new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
		
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
//	@GetMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//save employee to database
		employeeService.saveEmployee(employee);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
//	@RequestMapping(value = "/showFormForUpdate/{id}", method = RequestMethod.POST)
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		//get employee fom get server
		Employee employee = employeeService.getEmployeeById(id);
		
		//set employee as a model
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		//call delete employee method
		this.employeeService.deleteEmployeeById(id);
		
		return "redirect:/";
	}
	
	//Phan trang AHD SORT
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, 
			@RequestParam("sortFiled") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		
	int pageSize = 5;
	Page<Employee> page= employeeService.findPaginated(pageNo, pageSize,sortField,sortDir);
	List<Employee> listEmployees=page.getContent();
	
	model.addAttribute("currentPage",pageNo);
	model.addAttribute("totalPages", page.getTotalPages());
	model.addAttribute("totalItems",page.getTotalElements());
	
	model.addAttribute("sortFiled",sortField);
	model.addAttribute("sortDir", sortDir);
	model.addAttribute("reverseSortDir",sortDir.equals("asc") ? "desc":"asc");
	
	model.addAttribute("listEmployees",listEmployees);
	
	return "index";	
		
	}
}

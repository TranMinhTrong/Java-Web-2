package trong.ntu.thigiuaky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import trong.ntu.thigiuaky.models.Contact;
import trong.ntu.thigiuaky.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	//display list of emplyees
	@GetMapping("/")
	public String viewHomePage(Model model, String keyword) {
		 List<Contact> listContact = contactService.listAll(keyword);
	     model.addAttribute("keyword", keyword);
	     
		return findPaginated(1,"name","asc",model);
	}
	
	@GetMapping("/showNewContactForm")
	public String showNewContactForm(Model model) {
		
		Contact contact= new Contact();
		model.addAttribute("contact",contact);
		return "addcontact";
		
	}
	
//	@GetMapping("/saveEmployee")
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("contact") Contact contact) {
		//save employee to database
		contactService.saveContact(contact);
		
		return "redirect:/";
		
	}
	
//	@RequestMapping(value = "/showFormForUpdate/{id}", method = RequestMethod.POST)
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		//get employee fom get server
		Contact contact = contactService.getContactById(id);
		
		//set employee as a model
		model.addAttribute("contact", contact);
		return "updatecontact";
		
	}
	
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable(value = "id") long id) {
		//call delete employee method
		this.contactService.deleteContactById(id);
		
		return "redirect:/";
	}
	
	//Phan trang AHD SORT
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, 
			@RequestParam("sortFiled") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		
	int pageSize = 2;
	Page<Contact> page= contactService.findPaginated(pageNo, pageSize,sortField,sortDir);
	List<Contact> listContact=page.getContent();
	
	model.addAttribute("currentPage",pageNo);
	model.addAttribute("totalPages", page.getTotalPages());
	model.addAttribute("totalItems",page.getTotalElements());
	
	model.addAttribute("sortFiled",sortField);
	model.addAttribute("sortDir", sortDir);
	model.addAttribute("reverseSortDir",sortDir.equals("asc") ? "desc":"asc");
	
	model.addAttribute("listContact",listContact);
	
	return "index";	
		
	}
}

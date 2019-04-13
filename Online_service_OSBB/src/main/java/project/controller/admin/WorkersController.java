package project.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import project.dto.form.WorkersForm;
import project.service.WorkersService;
import project.validator.OsbbInfoValidator;
import project.validator.WorkersValidator;

@Controller
@RequestMapping("/admin/Option/Workers")
@SessionAttributes("workers")
public class WorkersController {
	
	@Autowired
	private WorkersService workersService;
	
	@ModelAttribute("workers")
	public WorkersForm getForm(){
		return new WorkersForm();
	}
	
	@InitBinder("workers")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new WorkersValidator());
	}
	
	@GetMapping
	public String workers(Model model){
		model.addAttribute("workerses", workersService.findAll());
		return "admin-Workers";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("workers", workersService.findForm(id));
		return workers(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		 workersService.delete(id);
		return "redirect:/admin/Option/Workers";
	}
	
	@PostMapping
	public String save(@ModelAttribute("workers") @Valid WorkersForm form, BindingResult br, Model model, SessionStatus status){
		
		if(br.hasErrors()) return workers(model);
		
		workersService.save(form);
		status.setComplete();
		
		return "redirect:/admin/Option/Workers";
		
	}

}

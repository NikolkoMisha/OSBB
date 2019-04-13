package project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import project.dto.form.PropositionsModerationForm;
import project.service.PropositionsModerationService;
import project.service.PropositionsService;

@Controller
@RequestMapping("/admin/PropositionsModeration")
@SessionAttributes("propositions")
public class PropositionsModerationController {

	@Autowired
	private PropositionsModerationService moderationService;
	@Autowired
	private PropositionsService propositionsService;
	
	@ModelAttribute("propositions")
	public PropositionsModerationForm getForm(){
		return new PropositionsModerationForm();
	}
	
	@GetMapping
	public String propositions(Model model){
		model.addAttribute("propositionses", propositionsService.findAll());
		return "admin-PropositionsModeration";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model){
		model.addAttribute("propositions", propositionsService.findForm(id));
		return propositions(model);
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		propositionsService.delete(id);
		return "redirect:/admin/PropositionsModeration";
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("propositions") PropositionsModerationForm form, BindingResult br, Model model, SessionStatus status){
		
		moderationService.save(form);
		status.setComplete();
		return "redirect:/admin/PropositionsModeration";
	}
	
	
	
	
	
	
	
}

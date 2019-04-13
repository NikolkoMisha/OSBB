package project.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.dto.form.PropositionsForm;
import project.service.PropositionsService;

@Controller
@RequestMapping("/Additionally/Пропозиції")
public class PropositionsController {


	@Autowired
	private  PropositionsService propositionsService;
	
	
	
	@ModelAttribute("propositions")
	public PropositionsForm getForm(){
		return new PropositionsForm();
	}
	
	@GetMapping
	public String news(Model model){
		model.addAttribute("propositionses", propositionsService.findAll());
		return "user-Пропозиції";
	}

	
	
	@PostMapping
	public String save(@ModelAttribute("propositions")  PropositionsForm form, BindingResult br,Model model ){
	
		propositionsService.save(form);
		return "redirect:/Additionally/Пропозиції";
	}

	
	
}

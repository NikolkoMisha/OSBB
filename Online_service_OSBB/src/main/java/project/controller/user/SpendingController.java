package project.controller.user;

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

import project.dto.form.SpendingForm;
import project.service.SpendingService;
import project.validator.MaintenanceValidator;
import project.validator.SpendingValidator;

@Controller
@RequestMapping("/Additionally/Spending")
@SessionAttributes("spending")
public class SpendingController {


	@Autowired
	private SpendingService spendingService;
	
	@ModelAttribute("spending")
	public SpendingForm getForm(){
		return new SpendingForm();
	}
	
	@InitBinder("spending")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new SpendingValidator(spendingService));
	}
	
	@GetMapping
	public String spending(Model model){
		model.addAttribute("spendings", spendingService.findAll());
		return "user-Spending";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model){
		model.addAttribute("spending", spendingService.findForm(id));
		return spending(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		spendingService.delete(id);
		return "redirect:/Additionally/Spending";
	}
	
	@PostMapping
	public String save(@ModelAttribute("spending") @Valid SpendingForm form, BindingResult br, Model model, SessionStatus status){
		
			if(br.hasErrors()) return spending(model);
		
			spendingService.save(form);
			status.setComplete();
		return "redirect:/Additionally/Spending";
		
	}
	
}

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

import project.dto.form.BalanceForm;
import project.service.BalanceService;
import project.validator.BalanceValidator;
import project.validator.MaintenanceValidator;

@Controller
@RequestMapping("/Additionally/Balance")
@SessionAttributes("balance")
public class BalanceController {

	
	@Autowired
	private BalanceService balanceService;
	
	@ModelAttribute("balance")
	public BalanceForm getForm(){
		return new BalanceForm();
	}
	
	@InitBinder("balance")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new BalanceValidator(balanceService));
	}
	
	@GetMapping
	public String balance(Model model){
		model.addAttribute("balances", balanceService.findAll());
		return "user-Balance";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model){
		model.addAttribute("balance", balanceService.findForm(id));
		return balance(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		balanceService.delete(id);
		return "redirect:/Additionally/Balance";
	}
	
	@PostMapping
	public String save(@ModelAttribute("balance") @Valid BalanceForm form, BindingResult br, Model model, SessionStatus status){
			
		if(br.hasErrors()) return balance(model);
		
			balanceService.save(form);
			status.setComplete();
		return "redirect:/Additionally/Balance";
		
	}
}

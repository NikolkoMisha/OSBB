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

import project.dto.form.DebtorForm;
import project.service.DebtorService;
import project.validator.AttentionValidator;
import project.validator.DebtorValidator;

@Controller
@RequestMapping("/Additionally/Список боржників")
@SessionAttributes("debtor")
public class DebtorContoller {

	@Autowired
	private DebtorService debtorService;
	
	@ModelAttribute("debtor")
	public DebtorForm getFrom(){
		return new DebtorForm();
	}
	
	@InitBinder("debtor")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new DebtorValidator(debtorService));
	}
	
	@GetMapping
	public String debtor(Model model){
		model.addAttribute("debtors", debtorService.findAll());
		return "user-Список боржників";
	}
	
	@GetMapping("/update/{id}")
	private String update(@PathVariable long id, Model model){
		model.addAttribute("debtor", debtorService.findForm(id));
		return debtor(model);
	}
	
	
	@GetMapping("delete/{id}")
	private String delete(@PathVariable int id){
		debtorService.delete(id);
		return "redirect:/Additionally/Список боржників";
	}
	
	@PostMapping
	public String save(@ModelAttribute("debtor") @Valid DebtorForm form, BindingResult br,Model model,SessionStatus status){
	
		if(br.hasErrors()) return debtor(model);	
		
		debtorService.save(form);
		status.setComplete();
		return "redirect:/Additionally/Список боржників";
	}
	
}

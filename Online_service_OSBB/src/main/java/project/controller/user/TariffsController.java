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

import project.dto.form.TariffsForm;
import project.service.TariffsService;
import project.validator.MaintenanceValidator;
import project.validator.TariffsValidator;

@Controller
@RequestMapping("/Additionally/Tariffs")
@SessionAttributes("tariffs")
public class TariffsController {

	@Autowired
	private TariffsService tariffsService;
	
	@ModelAttribute("tariffs")
	public TariffsForm getForm(){
		return new TariffsForm();
	}
	
	@InitBinder("tariffs")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new TariffsValidator(tariffsService));
	}
	
	@GetMapping()
	public String tariffs(Model model){
		model.addAttribute("tariffses", tariffsService.findAll());
	return "user-Tariffs";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model){
		model.addAttribute("tariffs", tariffsService.findForm(id));
		return tariffs(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		tariffsService.delete(id);
		return "redirect:/Additionally/Tariffs";
	}
	
	@PostMapping
	public String save(@ModelAttribute("tariffs") @Valid TariffsForm form, BindingResult br,Model model, SessionStatus status ){
	
		if(br.hasErrors()) return tariffs(model);
		
		tariffsService.save(form);
		status.setComplete();
		return "redirect:/Additionally/Tariffs";
	}
	
}

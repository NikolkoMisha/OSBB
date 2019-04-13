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

import project.dto.form.MaintenanceForm;
import project.service.MaintenanceService;
import project.validator.MaintenanceValidator;

@Controller
@RequestMapping("/Additionally/Maintenance")
@SessionAttributes("maintenance")
public class MaintenanceController {

	@Autowired
	private MaintenanceService maintenanceService;
	

	@ModelAttribute("maintenance")
	public MaintenanceForm getForm(){
		return new MaintenanceForm();
	}
	
	@InitBinder("maintenance")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new MaintenanceValidator(maintenanceService));
	}
	
	@GetMapping()
	public String maintenance(Model model){
		model.addAttribute("maintenances", maintenanceService.findAll());
	return "user-Maintenance";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model){
		model.addAttribute("maintenance", maintenanceService.findForm(id));
		return maintenance(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		maintenanceService.delete(id);
		return "redirect:/Additionally/Maintenance";
	}
	
	@PostMapping
	public String save(@ModelAttribute("maintenance")  @Valid MaintenanceForm form, BindingResult br,Model model, SessionStatus status ){
	
		 if(br.hasErrors()){
			 return "user-Maintenance";
		 }
		
		maintenanceService.save(form);
		status.setComplete();
		return "redirect:/Additionally/Maintenance";
	}
	
}

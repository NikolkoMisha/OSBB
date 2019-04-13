package project.controller.user;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.dto.form.AttentionForm;
import project.service.AttentionService;
import project.validator.AttentionValidator;

@Controller
@RequestMapping("/Additionally/Оголошення")
public class AttentionController {

	@Autowired
	private  AttentionService attentionService;
	
	
	
	@ModelAttribute("attention")
	public AttentionForm getForm(){
		return new AttentionForm();
	}
	
	@InitBinder("attention")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new AttentionValidator());
	}
	
	@GetMapping
	public String news(Model model){
		model.addAttribute("attentions", attentionService.findAll());
		return "user-Оголошення";
	}
	
//	@GetMapping("/update/{id}")
//	public String update(@PathVariable Integer id, Model model){
//		model.addAttribute("battery", batteryService.findOne(id));
//		return show(model);
//	}
	
	
//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable int id){
//		batteryService.delete(id);
//		return "redirect:/admin/type/battery";
//	}
	
	
	@PostMapping
	public String save(@ModelAttribute("attention") @Valid AttentionForm form, BindingResult br,Model model, String surname , Principal principal){
	
		if(br.hasErrors()) return news(model);
		
		attentionService.save(form, surname, principal);
		return "redirect:/Additionally/Оголошення";
	}
}
	



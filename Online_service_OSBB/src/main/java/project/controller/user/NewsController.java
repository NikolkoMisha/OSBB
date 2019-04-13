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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.dto.form.NewsForm;
import project.service.NewsModerationService;
import project.service.NewsService;
import project.validator.MaintenanceValidator;
import project.validator.NewsValidator;

@Controller
@RequestMapping("/Additionally/Додати новину")
public class NewsController {


	@Autowired
	private NewsService newsService;
	@Autowired
	private NewsModerationService newsModerationService;
	
	
	
	@ModelAttribute("news")
	public NewsForm getForm(){
		return new NewsForm();
	}
	
	@InitBinder("news")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new NewsValidator());
	}
	
	@GetMapping
	public String news(Model model){
		model.addAttribute("newses", newsModerationService.findAll());
		return "user-Додати новину";
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
	public String save(@ModelAttribute("news") @Valid NewsForm form, BindingResult br,Model model ){
	
		if(br.hasErrors()) return news(model);
		
		newsService.save(form);
		return "redirect:/Новини";
	}
}
	


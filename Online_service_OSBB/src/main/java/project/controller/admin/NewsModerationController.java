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

import project.dto.form.NewsModerationForm;
import project.service.NewsModerationService;
import project.service.NewsService;

@Controller
@RequestMapping("/admin/NewsModeration")
@SessionAttributes("news")
public class NewsModerationController {

	@Autowired
	private NewsModerationService newsModerationService;
	@Autowired
	private NewsService newsService;
	
	@ModelAttribute("news")
	public NewsModerationForm getForm(){
		return new NewsModerationForm();
	}
	
	@GetMapping
	public String news(Model model){
		model.addAttribute("newses", newsService.findAll());
		return "admin-NewsModeration";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model){
		model.addAttribute("news", newsService.findForm(id));
		return news(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		newsService.delete(id);
		return "redirect:/admin/NewsModeration";
	}
	
	@PostMapping
	public String save(@ModelAttribute("news") NewsModerationForm form, BindingResult br, Model model, SessionStatus status){
		
		newsModerationService.save(form);
		status.setComplete();
		return "redirect:/admin/NewsModeration";
	}
}

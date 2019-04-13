package project.controller.admin;


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


import project.entity.User;
import project.service.UserService;
import project.validator.UserValidator;

@Controller
@RequestMapping("/admin/law/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@InitBinder("user")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new UserValidator(userService));
	}
	
	@GetMapping
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "admin-registration";
	}
	
	@PostMapping
	public String save(@ModelAttribute("user") @Valid User admin, BindingResult br,Model model){
		  if (br.hasErrors()) {
	            return "admin-registration";
	        }
		userService.adminsave(admin);
		return "redirect:/admin/law/registration";
	}
}

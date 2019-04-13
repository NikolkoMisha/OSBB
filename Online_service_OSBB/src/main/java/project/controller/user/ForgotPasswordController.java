package project.controller.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.dto.ForgotPasswordEmail;
import project.dto.form.UserForm;
import project.entity.User;
import project.service.UserService;
import project.validator.UserValidator;

@Controller
@RequestMapping("/ForgotPassword")
public class ForgotPasswordController {

	private UserService userService; 
	
	
	
	@GetMapping
	public String forgot(){
//		System.out.println(userService.findByEmail(email));
////		model.addAttribute("user", userService.findByEmail(email));
		return "user-ForgotPassword";
	}
	
	@PostMapping
	public ModelAndView forgot(ModelAndView modelAndView, @RequestParam("email") String userEmail, HttpServletRequest request){
		
//		System.out.println(form.getEmail());
//	    User user =	userService.findByLogin(username);
	    
//			if(user!=null){
//				model.addAttribute("User", userService.findByEmail(form.getEmail()));
//			}
//		System.out.println(user.getEmail());
//		String mail = user.getEmail();
////		User userMail = new User();
////		for(User user : userService.findByEmail(form.getEmail())){
////			userMail.setEmail(user.getEmail());
////		}
//		mail = user.getEmail();
		
		Optional<User> optional = userService.findByEmail(userEmail);
		
		if(!optional.isPresent()){
			modelAndView.addObject("errorMessage", "We didn't find an account for that e-mail address.");
		}else{
			User user = optional.get();
			user.setPassword(UUID.randomUUID().toString());
			userService.ResetPassword(user);
		}
		
		
	}
	
	
	
}

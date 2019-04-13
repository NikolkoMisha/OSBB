package project.controller.user;


import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.dto.form.UserInfoForm;
import project.entity.*;
import project.service.AttentionService;
import project.service.NewsModerationService;
import project.service.PropositionsModerationService;
import project.service.PropositionsService;
import project.service.UserInfoService;
import project.service.UserService;
import project.validator.UserValidator;

@Controller
public class IndexController {
	

		@Autowired
		private UserService userService;
		@Autowired
		private UserInfoService userInfoService;
		@Autowired
		private NewsModerationService newsService;
		@Autowired
		private AttentionService attentionService;
		@Autowired
		private PropositionsService propositionService;

		
		@InitBinder("user")
		protected void bind(WebDataBinder binder){
			binder.setValidator(new UserValidator(userService));
		}
		
		
		@RequestMapping("/")
		public String indexShow(Model model,@CookieValue(defaultValue="0", name="userId") int id, HttpServletResponse response,@PageableDefault Pageable pageable,Principal principal){
			model.addAttribute("attentions", attentionService.findAll());
			model.addAttribute("propositionses", propositionService.findAll());
			model.addAttribute("newses", newsService.findAll());
			if(id==0){
				response.addCookie(new Cookie("userId", String.valueOf(id)));
			}

			if(principal!=null){
				System.out.println(principal.getName());
			}
			return "user-index";
		}	
		
		
		
		@GetMapping("/registration")
		public String registration(Model model){
			model.addAttribute("user", new User());
			return "user-registration";
		}
		
		@PostMapping("/registration")
		public String saveUser(@ModelAttribute("user") @Valid User user,@ModelAttribute("userInfo") UserInfoForm form, BindingResult br,Model model, Principal principal){
			  if (br.hasErrors()) {
		            return "user-registration";
		        }
			userInfoService.saveR(form);
			userService.save(user);
			return "redirect:/login";
		}
		
		@GetMapping("/login")
		public String login(){
			return "user-login";
		}
		
		
		@GetMapping("/Additionally")
		public String plus(){
			return "user-Additionally";
		}
	
		@RequestMapping("/admin")
		public String admin(){
			return "admin-admin";
		}
		
	
		
		@RequestMapping("/Новини" )
		public String newsShow(Model model){
			model.addAttribute("newses", newsService.findAll());
			return "user-Новини";
		}

		
		@RequestMapping("/Additionally/Додати новину")
		public String insertNews(Model model){
			model.addAttribute("news", new News());
			return "user-Додати новину";
		}

		

	
		

}

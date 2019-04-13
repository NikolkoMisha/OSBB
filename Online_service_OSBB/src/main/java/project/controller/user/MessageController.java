package project.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

import project.dto.form.MessageForm;
import project.entity.Message;
import project.service.MessageService;
import project.service.UserService;
import project.validator.ChatValidator;
import project.validator.NewsValidator;

@Controller
@RequestMapping("/Chat")
public class MessageController {
	
	List<MessageForm> ms = new ArrayList<>();
	

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	

	@ModelAttribute("message")
	public MessageForm getForm(){
		return new MessageForm();
	}
	
	@InitBinder("message")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ChatValidator());
	}
	
//	@GetMapping
//	public String user(@PathVariable Long id, Model model){
//		model.addAttribute("user", userService.findOne(id));
//		return "user-Chat";
//	}
	
	@GetMapping
	public String news(Model model, Principal principal){
//		model.addAttribute("message", new Message());
		model.addAttribute("messages", messageService.findAll());
		return "user-Chat";
	}

	
	
//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable int id){
//		batteryService.delete(id);
//		return "redirect:/admin/type/battery";
//	}
	
	
	
	@PostMapping
	public String save(@ModelAttribute("message") @Valid  MessageForm form,BindingResult br,Model model, Principal principal ){ 
		Date date = new Date();
		form.setHour(date.getHours());
		form.setMinutes(date.getMinutes());
		form.setSeconds(date.getSeconds());
		form.setDate(date.getDate());
		if(date.getMonth()==0){
			String month = "Січня";
			form.setMonth(month);
		}
		if(date.getMonth()==1){
			String month = "Лютого";
			form.setMonth(month);
		}
		if(date.getMonth()==2){
			String month = "Березня";
			form.setMonth(month);
		}
		if(date.getMonth()==3){
			String month = "Квітня";
			form.setMonth(month);
		}
		if(date.getMonth()==4){
			String month = "Травня";
			form.setMonth(month);
		}
		if(date.getMonth()==5){
			String month = "Червня";
			form.setMonth(month);
		}
		if(date.getMonth()==6){
			String month = "Липня";
			form.setMonth(month);
		}
		if(date.getMonth()==7){
			String month = "Серпня";
			form.setMonth(month);
		}
		if(date.getMonth()==8){
			String month = "Вересня";
			form.setMonth(month);
		}
		if(date.getMonth()==9){
			String month = "Жовтня";
			form.setMonth(month);
		}
		if(date.getMonth()==10){
			String month = "Листопада";
			form.setMonth(month);
		}
		if(date.getMonth()==11){
			String month = "Грудня";
			form.setMonth(month);
		}
		form.setYear(1900+date.getYear());
		
		if(br.hasErrors()) return "redirect:/Chat";
//		ms.add(form);
//		Collections.reverse(ms);
//		System.out.println(ms.toString());
		messageService.save(form, principal);
		return "redirect:/Chat";
	}
	
}

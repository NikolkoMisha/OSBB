package project.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.service.OsbbInfoService;
import project.service.WorkersService;

@Controller
@RequestMapping("/Contacts")
public class ContactsController {

	@Autowired
	private OsbbInfoService osbbInfoService;
	@Autowired WorkersService workersService;
	
	@GetMapping
	public String info(Model model){
		model.addAttribute("infos", osbbInfoService.findAll());
		model.addAttribute("workerses", workersService.findAll());
		return "user-Contacts";
	}
	
}

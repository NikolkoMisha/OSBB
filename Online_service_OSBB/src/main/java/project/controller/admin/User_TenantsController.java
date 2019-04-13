package project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.service.UserInfoService;
import project.service.UserService;


@Controller
@RequestMapping("/admin/Tenants")
public class User_TenantsController {


	@Autowired
	private UserInfoService userInfoService;

	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("userInfos", userInfoService.findAll());
		return "admin-Tenants";
	}
	

	
}

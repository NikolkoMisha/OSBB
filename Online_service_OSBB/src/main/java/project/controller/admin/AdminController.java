package project.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {



	@RequestMapping("/admin/Tenants")
	public String tenants(){
		return "admin-Tenants";
	}
	
	@RequestMapping("/admin/Option")
	public String option(){
		return "admin-Option";
	}

}
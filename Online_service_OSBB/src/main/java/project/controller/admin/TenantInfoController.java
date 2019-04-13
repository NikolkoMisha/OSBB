package project.controller.admin;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import project.dto.form.UserInfoForm;
import project.entity.UserInfo;
import project.service.UserInfoService;
import project.validator.TenantInfoValidator;

@Controller
@RequestMapping("/admin/Tenants/TenantInfo")
@SessionAttributes("userInfo")
public class TenantInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	

	
	@ModelAttribute("userInfo")
	public UserInfoForm getForm(){
		return new UserInfoForm();
	}
	
	@InitBinder("userInfo")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new TenantInfoValidator());
	}
	
	@GetMapping("/{id}")
	public String tenants(@PathVariable Long id, Model model){
		UserInfo userInfo = userInfoService.findOne(id);
		List<Object> date = new ArrayList<>();
		date.add(userInfo.getDate());
		model.addAttribute("userInfo", userInfoService.findForm(id));
		model.addAttribute("date" ,date);
		return "admin-TenantInfo";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model){
		model.addAttribute("userInfo", userInfoService.findForm(id));
		return tenants(id, model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		userInfoService.delete(id);
		return "redirect:/admin/Tenants";
	}
	
	@PostMapping("/{id}")
	public String save(@ModelAttribute("userInfo") @Valid UserInfoForm form,BindingResult br, Model model, SessionStatus status){
		
//		if(br.hasErrors()) return tenants(form.getId(), model);
		
		userInfoService.save(form);
		status.setComplete();
		
		return "redirect:/admin/Tenants/TenantInfo/{id}";
		
	}

}

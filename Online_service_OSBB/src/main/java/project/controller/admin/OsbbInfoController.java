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
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import project.dto.form.OsbbInfoForm;
import project.service.OsbbInfoService;
import project.validator.AttentionValidator;
import project.validator.OsbbInfoValidator;
import project.validator.ReceiptsValidator;

@Controller
@RequestMapping("/admin/Option/OsbbInfo")
@SessionAttributes("osbbInfo")
public class OsbbInfoController {

	@Autowired
	private OsbbInfoService osbbInfoService;
	
	@ModelAttribute("osbbInfo")
	public OsbbInfoForm  getForm(){
		return new OsbbInfoForm();
	}
	
	@InitBinder("osbbInfo")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new OsbbInfoValidator());
	}
	
	@GetMapping
	public String OsbbInfo(Model model){
		model.addAttribute("osbbInfos", osbbInfoService.findAll());
		return "admin-OsbbInfo";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model){
		model.addAttribute("osbbInfo", osbbInfoService.findForm(id));
		return OsbbInfo(model);
	}
	
	@PostMapping
	public String save(@ModelAttribute("osbbInfo") @Valid OsbbInfoForm form, BindingResult br, Model model, SessionStatus status){

		if(br.hasErrors()) return OsbbInfo(model);

		osbbInfoService.save(form);
		status.setComplete();
		return "redirect:/admin/Option/OsbbInfo";
		
	}
	
}

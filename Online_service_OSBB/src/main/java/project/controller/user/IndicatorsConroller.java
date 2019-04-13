package project.controller.user;

import java.security.Principal;
import java.util.Date;

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

import project.dto.form.IndicatorsForm;
import project.entity.Indicators;
import project.service.IndicatorsService;
import project.service.TariffsService;
import project.validator.AttentionValidator;
import project.validator.IndicatorsValidator;

@Controller
@RequestMapping("/Indexes")
public class IndicatorsConroller {

	@Autowired
	private IndicatorsService indicatorsService;
	@Autowired
	private TariffsService tariffsService;
	
	@ModelAttribute("indicators")
	public IndicatorsForm getForm(){
		return new IndicatorsForm();
	}
	
	
	@GetMapping
	public String indicators(Model model){
		model.addAttribute("tariffses", tariffsService.findAll());
//		model.addAttribute("indicatorses", indicatorsService.findAll());
		model.addAttribute("indicators", new Indicators());
		return "user-Indexes";
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("indicators") IndicatorsForm form, BindingResult br, Model model, Principal principal, String surname){
		try{
		Date date = new Date();
		
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
		
		indicatorsService.save(form,principal, surname);
		return "redirect:/Indexes";
		}catch (NumberFormatException e) {
			return "redirect:/Indexes";
		}
	}
}

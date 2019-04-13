package project.controller.admin;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
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

import project.dto.form.ReceiptsForm;
import project.entity.Indicators;
import project.entity.Tariffs;
import project.entity.User;
import project.entity.UserInfo;
import project.service.IndicatorsService;
import project.service.OsbbInfoService;
import project.service.ReceiptsService;
import project.service.TariffsService;
import project.service.UserInfoService;
import project.service.UserService;
import project.validator.BalanceValidator;
import project.validator.ReceiptsValidator;

@Controller
@RequestMapping("/admin/Receipts")
public class ADMINReceiptsController {

	@Autowired
	private ReceiptsService receiptsService ;
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private TariffsService tariffsService;
	@Autowired
	private IndicatorsService indicatorsService;
	@Autowired
	private OsbbInfoService osbbInfoService;
	
	
	
	
	@ModelAttribute("receipts")
	public ReceiptsForm getForm(){
		return new ReceiptsForm();
	}
	
	@InitBinder("receipts")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ReceiptsValidator(receiptsService));
	}
	
	
	@GetMapping
	public String tenants(Model model){
		model.addAttribute("userInfos", userInfoService.findAll());
		model.addAttribute("tariffses", tariffsService.findAll());
		model.addAttribute("osbbInfos", osbbInfoService.findAll());
		return "admin-Receipts";
	}
		
	@GetMapping("/{id}")
	public String receipts(@PathVariable long id, Model model, Principal principal){
		
		ArrayList<BigDecimal> sum = new ArrayList<>();
		ArrayList<BigDecimal> totalSum = new ArrayList<>();
		List<BigDecimal> privileges = new ArrayList<>();
		List<BigDecimal> totalPrivileges = new ArrayList<>();
		List<BigDecimal> finalSum = new ArrayList<>();
		List<BigDecimal> totalFinalSum = new ArrayList<>();
		List<Tariffs> tariffs = tariffsService.findAll();
		try{
		List<Indicators> indicators = indicatorsService.findIndicatorsByUserId(id);
		
		List <BigDecimal> totalDebt = new ArrayList<>();
		UserInfo userInfo = userInfoService.findOne(id);
		totalDebt.add(userInfo.getFlatAreaDebt()
				.add(userInfo.gethMaintenanceDebt()).add(userInfo.gethWaterDebt())
				.add(userInfo.getcWaterDebt()).add(userInfo.getHeatingDebt()));
		privileges.add((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea())).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		privileges.add((tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance())).multiply(new BigDecimal(0)).setScale(2, BigDecimal.ROUND_HALF_UP));
		privileges.add((tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater())).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		privileges.add((tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater())).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		privileges.add((tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		totalPrivileges.add(((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea()))
				.add(tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance()))
				.add(tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater()))
					.add(tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater()))
						.add(tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating()))).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		finalSum.add((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea())).subtract((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea())).multiply(userInfo.getPrivileges())).setScale(2, BigDecimal.ROUND_HALF_UP));
		finalSum.add((tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance())).setScale(2, BigDecimal.ROUND_HALF_UP));
		finalSum.add((tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater())).subtract((tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater())).multiply(userInfo.getPrivileges())).setScale(2, BigDecimal.ROUND_HALF_UP));
		finalSum.add((tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater())).subtract((tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater())).multiply(userInfo.getPrivileges())).setScale(2, BigDecimal.ROUND_HALF_UP));
		finalSum.add((tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).subtract((tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).multiply(userInfo.getPrivileges())).setScale(2, BigDecimal.ROUND_HALF_UP));
		totalFinalSum.add(((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea()))
				.add(tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance()))
					.add(tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater()))
						.add(tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater()))
							.add(tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())))
				.subtract(((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea()))
						.add(tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance()))
							.add(tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater()))
								.add(tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater()))
									.add(tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating()))).multiply(userInfo.getPrivileges()))
				.add(userInfo.getFlatAreaDebt().add(userInfo.gethMaintenanceDebt()).add(userInfo.gethWaterDebt()).add(userInfo.getcWaterDebt()).add(userInfo.getHeatingDebt()))
						.setScale(2, BigDecimal.ROUND_HALF_UP));
		List<String> unit = new ArrayList<>();
		unit.add("куб.");
		unit.add("куб.");
		unit.add("ГКал");
		sum.add((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea())).setScale(2, BigDecimal.ROUND_HALF_UP));
		sum.add((tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance())).setScale(2, BigDecimal.ROUND_HALF_UP));
		sum.add((tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater())).setScale(2, BigDecimal.ROUND_HALF_UP));
		sum.add((tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater())).setScale(2, BigDecimal.ROUND_HALF_UP));
		sum.add((tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).setScale(2, BigDecimal.ROUND_HALF_UP));
		totalSum.add ((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea()))
					.add(tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance()))
						.add(tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater()))
							.add(tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater()))
								.add(tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).setScale(2, BigDecimal.ROUND_HALF_UP));
		model.addAttribute("userInfos", userInfoService.findAll());
		model.addAttribute("userInfo", userInfoService.findOne(id));
		model.addAttribute("userInfo", userInfoService.findForm(id));
		model.addAttribute("osbbInfos", osbbInfoService.findAll());
		model.addAttribute("tariffses", tariffsService.findAll());
		model.addAttribute("indicatorses", indicatorsService.findIndicatorsByUserId(id));
		model.addAttribute("indicators", indicatorsService.findCurrentIndicatorsByUserId(id));
		model.addAttribute("indicatos", indicatorsService.findPreviousIndicatorsByUserId(id));
		model.addAttribute("privileges", privileges);
		model.addAttribute("finalSum", finalSum);
		model.addAttribute("totalFinalSum", totalFinalSum);
		model.addAttribute("sums", sum);
		model.addAttribute("units", unit);
		model.addAttribute("totalSums", totalSum);
		model.addAttribute("totalPrivileges", totalPrivileges);
		model.addAttribute("totalDebts", totalDebt);
	}catch (IndexOutOfBoundsException e) {
		model.addAttribute("userInfo", userInfoService.findForm(id));
		return tenants(model);
	}
		return "admin-Receipts";
	}
	
	
	@PostMapping("/{id}")
	public String save(@ModelAttribute("receipts") @Valid ReceiptsForm form,@PathVariable Long id ,BindingResult br,Model model, Principal principal ){ 
			
		Date date = new Date();
		if(date.getMonth()==0){
			String month = "Січень";
			form.setMonth(month);
		}
		if(date.getMonth()==1){
			String month = "Лютий";
			form.setMonth(month);
		}
		if(date.getMonth()==2){
			String month = "Березень";
			form.setMonth(month);
		}
		if(date.getMonth()==3){
			String month = "Квітень";
			form.setMonth(month);
		}
		if(date.getMonth()==4){
			String month = "Травень";
			form.setMonth(month);
		}
		if(date.getMonth()==5){
			String month = "Червень";
			form.setMonth(month);
		}
		if(date.getMonth()==6){
			String month = "Липень";
			form.setMonth(month);
		}
		if(date.getMonth()==7){
			String month = "Серпень";
			form.setMonth(month);
		}
		if(date.getMonth()==8){
			String month = "Вересень";
			form.setMonth(month);
		}
		if(date.getMonth()==9){
			String month = "Жовтень";
			form.setMonth(month);
		}
		if(date.getMonth()==10){
			String month = "Листопад";
			form.setMonth(month);
		}
		if(date.getMonth()==11){
			String month = "Грудень";
			form.setMonth(month);
		}
	
		form.setYear(1900+date.getYear());
		
		
		receiptsService.save(form, id);
		return "redirect:/admin/Receipts";
	}
	
	
	
}

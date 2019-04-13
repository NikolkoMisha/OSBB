package project.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.MaintenanceForm;
import project.service.MaintenanceService;

public class MaintenanceValidator implements Validator{

	private final static Pattern sPattern = Pattern.compile("^[а-яА-ЯіІйЙa-zA-Z ]+$");
	
	private final static Pattern pPattern = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	
	private final MaintenanceService tenanceService;
	
	public MaintenanceValidator(MaintenanceService tenanceService) {
		this.tenanceService = tenanceService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return MaintenanceForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MaintenanceForm form = (MaintenanceForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",  "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",  "Неможе бути пустим");
		
		if(!sPattern.matcher(form.getName()).matches()){
			errors.rejectValue("name", "", "Використовуйте тільки букви");
		}
		if(!pPattern.matcher(form.getPrice()).matches()){
			errors.rejectValue("price", "", "Використовуйте тільки цифри");
		}
		
		
	}


}

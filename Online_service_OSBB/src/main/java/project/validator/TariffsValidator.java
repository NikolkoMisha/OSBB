package project.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.MaintenanceForm;
import project.dto.form.TariffsForm;
import project.service.TariffsService;

public class TariffsValidator implements Validator{

	private final static Pattern sPattern = Pattern.compile("^[а-яА-ЯіІйЙa-zA-Z ]+$");
	
	private final static Pattern pPattern = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	private final TariffsService tariffsService;
	
	public TariffsValidator(TariffsService tariffsService) {
		this.tariffsService = tariffsService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(TariffsForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TariffsForm form = (TariffsForm) target;
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

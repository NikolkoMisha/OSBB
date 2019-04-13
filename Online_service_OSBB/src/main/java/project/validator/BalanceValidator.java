package project.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.BalanceForm;
import project.service.BalanceService;

public class BalanceValidator implements Validator{

	private final static Pattern pPattern = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	private final BalanceService balanceService;
	
	
	
	public BalanceValidator(BalanceService balanceService) {
		this.balanceService = balanceService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(BalanceForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BalanceForm form = (BalanceForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",  "Неможе бути пустим");
		if(!pPattern.matcher(form.getPrice()).matches()){
			errors.rejectValue("price", "", "Використовуйте тільки цифри");
		}
	}

}

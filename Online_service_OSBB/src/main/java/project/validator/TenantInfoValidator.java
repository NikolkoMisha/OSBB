package project.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.UserInfoForm;

public class TenantInfoValidator implements Validator{

	private final static Pattern sPattern = Pattern.compile("^[а-яА-ЯіІйЙa-zA-Z ]+$");
	
	private final static Pattern zPattern = Pattern.compile("^[0-9]*?[0-9]+$");
	
	private final static Pattern pPattern = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserInfoForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserInfoForm form = (UserInfoForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "initials", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "flatArea", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "privileges", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "flatAreaDebt", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hMaintenanceDebt", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hWaterDebt", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cWaterDebt", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "heatingDebt", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalAccount", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "turn", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countTenant", "", "Неможе бути пустим");
		if(!sPattern.matcher(form.getInitials()).matches()){
			errors.rejectValue("initials", "", "Використовуйте тільки букви");
		}
		if(!pPattern.matcher(form.getFlatArea()).matches()){
			errors.rejectValue("flatArea", "", "Використовуйте тільки цифри");
		}
		if(!pPattern.matcher(form.getFlatAreaDebt()).matches()){
			errors.rejectValue("flatAreaDebt", "", "Використовуйте тільки цифри");
		}
		if(!pPattern.matcher(form.gethMaintenanceDebt()).matches()){
			errors.rejectValue("hMaintenanceDebt", "", "Використовуйте тільки цифри");
		}
		if(!pPattern.matcher(form.gethWaterDebt()).matches()){
			errors.rejectValue("hWaterDebt", "", "Використовуйте тільки цифри");
		}
		if(!pPattern.matcher(form.getcWaterDebt()).matches()){
			errors.rejectValue("cWaterDebt", "", "Використовуйте тільки цифри");
		}
		if(!pPattern.matcher(form.getHeatingDebt()).matches()){
			errors.rejectValue("heatingDebt", "", "Використовуйте тільки цифри");
		}
		if(!zPattern.matcher(form.getHeatingDebt()).matches()){
			errors.rejectValue("privileges", "", "Введіть у відсотках, наприклад 50%");
		}
		if(!zPattern.matcher(form.getHeatingDebt()).matches()){
			errors.rejectValue("personalAccount", "", "Використовуйте тільки цілі числа");
		}
		if(!zPattern.matcher(form.getHeatingDebt()).matches()){
			errors.rejectValue("turn", "", "Використовуйте тільки цілі числа");
		}
		if(!zPattern.matcher(form.getHeatingDebt()).matches()){
			errors.rejectValue("countTenant", "", "Використовуйте тільки цілі числа");
		}
	}

}

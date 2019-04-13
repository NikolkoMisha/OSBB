package project.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.OsbbInfoForm;

public class OsbbInfoValidator implements Validator{

	private final static Pattern pPattern = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(OsbbInfoForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OsbbInfoForm form = (OsbbInfoForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "osbbName", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eDRPOU", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankScore", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankName", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankDetails", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fName", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneOSBB", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workSchedule", "", "Неможе бути пустим");
		
		if(!pPattern.matcher(form.geteDRPOU()).matches()){
			errors.rejectValue("eDRPOU", "", "Використовуйте тільки цифри");
		}if(!pPattern.matcher(form.getBankScore()).matches()){
			errors.rejectValue("bankScore", "", "Використовуйте тільки цифри");
		}if(!pPattern.matcher(form.getBankDetails()).matches()){
			errors.rejectValue("bankDetails", "", "Використовуйте тільки цифри");
		}
	}

}

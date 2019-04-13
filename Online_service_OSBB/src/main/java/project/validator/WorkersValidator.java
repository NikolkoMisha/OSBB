package project.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.WorkersForm;

public class WorkersValidator implements Validator{

	private final static Pattern sPattern = Pattern.compile("^(\\[а-яА-ЯіІйЙa-zA-Z] +)?$");
	
	private final static Pattern pPattern = Pattern.compile("^(\\+380[0-9]{9})?$");
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(WorkersForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WorkersForm form = (WorkersForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "",  "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",  "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "",  "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fathername", "",  "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneWorker", "",  "Неможе бути пустим");
		if(!sPattern.matcher(form.getName()).matches()){
			errors.rejectValue("name", "", "Використовуйте тільки букви");
		}
		if(!sPattern.matcher(form.getSurname()).matches()){
			errors.rejectValue("surname", "", "Використовуйте тільки букви");
		}
		if(!sPattern.matcher(form.getFathername()).matches()){
			errors.rejectValue("fathername", "", "Використовуйте тільки букви");
		}
		if(!pPattern.matcher(form.getPhoneWorker()).matches()){
			errors.rejectValue("phoneWorker", "", "Вкажіть номер як на прикладі");
		}
		
	}

}

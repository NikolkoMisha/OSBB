package project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.NewsForm;

public class NewsValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(NewsForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "theme", "",  "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "",  "Неможе бути пустим");
	}

}

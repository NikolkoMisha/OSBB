package project.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.MessageForm;

public class ChatValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(MessageForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "",  "Неможе бути пустим");
	}

}

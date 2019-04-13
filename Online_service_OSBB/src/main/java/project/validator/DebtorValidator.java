package project.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.DebtorForm;
import project.entity.Debtor;
import project.service.DebtorService;

public class DebtorValidator implements Validator{
	
	private final static Pattern sPattern = Pattern.compile("^[(а-яА-ЯіІйЙa-zA-Z)([,.:;]) ]+$");
	
	private final static Pattern pPattern = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	
	private final DebtorService debtorService;

	public DebtorValidator(DebtorService debtorService) {
		this.debtorService = debtorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(DebtorForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DebtorForm form = (DebtorForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "infoName", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apartment", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "infoSum", "", "Неможе бути пустим");

		if(!sPattern.matcher(form.getInfoName()).matches()){
			errors.rejectValue("infoName", "", "Використовуйте тільки букви");
		}
		if(!pPattern.matcher(form.getApartment()).matches()){
			errors.rejectValue("apartment", "", "Використовуйте тільки цифри");
		}
		if(!pPattern.matcher(form.getInfoSum()).matches()){
			errors.rejectValue("infoSum", "", "Використовуйте тільки цифри");
		}
	}

}

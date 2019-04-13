package project.validator;

import java.sql.Date;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.dto.form.IndicatorsForm;
import project.service.IndicatorsService;

public class IndicatorsValidator implements Validator{

//	private final static Pattern sPattern = Pattern.compile("123456789");
	
	private final IndicatorsService indicatorsService;
	
	
	
	public IndicatorsValidator(IndicatorsService indicatorsService) {
		this.indicatorsService = indicatorsService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(IndicatorsForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		IndicatorsForm form = (IndicatorsForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Hwater", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Cwater", "", "Неможе бути пустим");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "heating", "", "Неможе бути пустим");
		if (indicatorsService.findByMonth(form.getMonth())!=null && indicatorsService.findByYear(form.getYear())!=null){
			errors.rejectValue("month", "", "Вже існує");
		}
	}

}

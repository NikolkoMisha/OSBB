package project.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import project.entity.User;
import project.service.UserService;

public class UserValidator implements Validator{

	private final static Pattern ePattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$") ;
	
	private final static Pattern sPattern = Pattern.compile("123456789");
	
	private final UserService userService;
	
	public UserValidator(UserService userService){
		this.userService = userService;
	}
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}


	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "",  "Неможе бути пустим ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",  "Неможе бути пустим ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "",  "Неможе бути пустим ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "",  "Неможе бути пустим  ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",  "Неможе бути пустим  ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secret", "",  "Неможе бути пустим  ");
		
		if(userService.findByEmail(user.getEmail())!=null){
			errors.rejectValue("email", "", "Акаунт з таким email вже існує");
		}
		if(!ePattern.matcher(user.getEmail()).matches()){
			errors.rejectValue("email", "", "Некоректний email");
		}
		if(!sPattern.matcher(user.getSecret()).matches()){
			errors.rejectValue("secret", "", "Кодове слово невірне");
		}
		
		if (userService.findByLogin(user.getUsername())!=null){
			errors.rejectValue("login", "", "Користувач з таким login вже існує");
		}
		
	}
}
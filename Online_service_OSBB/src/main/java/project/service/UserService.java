package project.service;

import java.util.List;
import java.util.Optional;

import project.dto.ForgotPasswordEmail;
import project.dto.form.UserForm;
import project.entity.User;

public interface UserService {

	List<User> findAll();
	
	User findOne(long id);
	
//	UserForm findForm(long id);
	
	void save(User user);
	
	void ResetPassword(User form);
	
	String RandomNumber(String randomNumber);
	
	User findByLogin(String username);
	
	User findByEmail (String email);
	
	void adminsave(User admin);
	
	void delete(long id);
	
	
	
	long createNewUser();

	

	
	
	
}

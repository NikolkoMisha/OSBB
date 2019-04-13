package project.service;

import java.security.Principal;
import java.util.List;

import project.dto.form.UserInfoForm;
import project.entity.UserInfo;

public interface UserInfoService {

	
	List<UserInfo> findAll();
	UserInfo findOne(Long id);
	void delete(long id); 
	void save(UserInfoForm form);
	void saveR(UserInfoForm form);
	UserInfoForm findForm(long id);
	UserInfo findBySurname(String surname, Principal principal);
}

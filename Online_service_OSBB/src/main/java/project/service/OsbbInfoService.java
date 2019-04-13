package project.service;

import java.util.List;

import project.dto.form.OsbbInfoForm;
import project.entity.OsbbInfo;

public interface OsbbInfoService {

	List<OsbbInfo> findAll();
	OsbbInfo findOne(Long id);
	void delete(long id); 
	void save(OsbbInfoForm form);
	OsbbInfoForm findForm(long id);
	
}

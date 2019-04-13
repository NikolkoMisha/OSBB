package project.service;

import java.util.List;

import project.dto.form.WorkersForm;
import project.entity.Workers;

public interface WorkersService {

	List<Workers> findAll();
	Workers findOne(int id);
	void delete(int id); 
	void save(WorkersForm form);
	WorkersForm findForm(int id);
	
}

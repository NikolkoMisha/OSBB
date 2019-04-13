package project.service;

import java.util.List;

import project.dto.form.SpendingForm;
import project.entity.Spending;

public interface SpendingService {

	List<Spending> findAll();
	Spending findOne(Long id);
	void delete(long id); 
	void save(SpendingForm form);
	SpendingForm findForm(long id);
}

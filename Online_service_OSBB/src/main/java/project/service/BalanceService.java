package project.service;

import java.util.List;

import project.dto.form.BalanceForm;
import project.entity.Balance;



public interface BalanceService {

	List<Balance> findAll();
	Balance findOne(Long id);
	void delete(long id); 
	void save(BalanceForm form);
	BalanceForm findForm(long id);
	
}

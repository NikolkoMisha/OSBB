package project.service;

import java.util.List;

import project.dto.form.DebtorForm;
import project.entity.Debtor;

public interface DebtorService {

	
	List<Debtor> findAll();
	Debtor findOne(Long id);
	void delete(long id);
	void save(DebtorForm form);
	DebtorForm findForm(long id);
}

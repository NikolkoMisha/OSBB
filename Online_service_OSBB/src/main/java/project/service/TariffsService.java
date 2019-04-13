package project.service;

import java.util.List;

import project.dto.form.TariffsForm;
import project.entity.Tariffs;

public interface TariffsService {

	List<Tariffs> findAll();
	Tariffs findOne(long id);
	void delete(long id); 
	void save(TariffsForm form);
	TariffsForm findForm(long id); 
	Tariffs findByName(String name);
}

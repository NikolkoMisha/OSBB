package project.service;

import java.util.List;

import project.dto.form.MaintenanceForm;
import project.entity.Maintenance;

public interface MaintenanceService {

	List<Maintenance> findAll();
	Maintenance findOne(Long id);
	void delete(long id); 
	void save(MaintenanceForm form);
	MaintenanceForm findForm(long id);
	Maintenance findByName(String name);
}

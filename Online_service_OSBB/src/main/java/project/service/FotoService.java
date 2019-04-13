package project.service;

import java.util.List;

import project.dto.form.FotoForm;
import project.entity.Foto;

public interface FotoService {

	List<Foto> findAll();
	Foto findOne(long id);
	void delete(long id); 
	void save(FotoForm form);
	FotoForm findForm(long id);
	
}

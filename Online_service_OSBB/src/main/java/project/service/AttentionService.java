package project.service;

import java.security.Principal;
import java.util.List;

import project.dto.form.AttentionForm;
import project.entity.Attention;

public interface AttentionService {

	
	List<Attention> findAll();
	Attention findOne(Long id);
	void delete(long id); 
	void save(AttentionForm form,String surname ,Principal principal);
}

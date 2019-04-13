package project.service;

import java.util.List;

import project.dto.form.PropositionsModerationForm;
import project.entity.PropositionsModeration;

public interface PropositionsModerationService {

	List<PropositionsModeration> findAll();
	PropositionsModeration findOne(long id);
	void delete(long id); 
	void save(PropositionsModerationForm form);
//	NewsModerationForm findForm(long id);
//	NewsModeration findByNews(String theme);
}

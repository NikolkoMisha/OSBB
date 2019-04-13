package project.service;

import java.util.List;

import project.dto.form.PropositionsForm;
import project.dto.form.PropositionsModerationForm;
import project.entity.Propositions;

public interface PropositionsService {

	List<Propositions> findAll();
	Propositions findOne(Long id);
	void delete(long id); 
	void save(PropositionsForm form);
	PropositionsModerationForm findForm(long id);
}

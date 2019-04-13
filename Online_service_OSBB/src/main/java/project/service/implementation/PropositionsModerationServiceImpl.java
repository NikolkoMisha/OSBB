package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.dto.form.PropositionsModerationForm;
import project.entity.PropositionsModeration;
import project.repository.PropositionsModerationRepository;
import project.service.PropositionsModerationService;
//import project.service.PropositionsService;

@Service
public class PropositionsModerationServiceImpl implements PropositionsModerationService{

	@Autowired
	private PropositionsModerationRepository propositionsModerationRepository;
//	@Autowired
//	private PropositionsService propositionsSercive;
	
	@Override
	public List<PropositionsModeration> findAll() {
		return propositionsModerationRepository.findAll();
	}

	@Override
	public PropositionsModeration findOne(long id) {
		return propositionsModerationRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		propositionsModerationRepository.delete(id);
	}

	@Override
	public void save(PropositionsModerationForm form) {
		PropositionsModeration moderation = new PropositionsModeration();
//		News news = newsService.findOne(id);
		moderation.getId();
//		moderation.setId(form.getId());
		moderation.setTheme(form.getTheme());
		moderation.setText(form.getText());
		moderation.setPropositionsId(form.getUserId());
		moderation.setVersion(form.getVersion());
		moderation = propositionsModerationRepository.saveAndFlush(moderation);
		propositionsModerationRepository.save(moderation);
	}

}

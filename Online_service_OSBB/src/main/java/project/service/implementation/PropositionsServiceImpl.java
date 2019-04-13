package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.form.NewsModerationForm;
import project.dto.form.PropositionsForm;
import project.dto.form.PropositionsModerationForm;
import project.entity.News;
import project.entity.Propositions;
import project.repository.PropositionsRepository;
import project.service.PropositionsService;
import project.service.FileWriter;
import project.service.FileWriter.Folder;

@Service
public class PropositionsServiceImpl implements PropositionsService {

	@Autowired
	private PropositionsRepository propositionsRepository;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public List<Propositions> findAll() {
		return propositionsRepository.findAll();
	}

	@Override
	public Propositions findOne(Long id) {
		return propositionsRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		propositionsRepository.delete(id);
	}

	@Override
	public void save(PropositionsForm form) {
		Propositions propositions = new Propositions();
		propositions.setId(form.getId());
		propositions.setTheme(form.getTheme());
		propositions.setText(form.getText());
		propositions = propositionsRepository.saveAndFlush(propositions);
		if(fileWriter.write(Folder.PROPOSITIONS, form.getFile(), propositions.getId())){
			if(propositions.getVersion()==null)propositions.setVersion(0);
			else propositions.setVersion(propositions.getVersion()+1);}
		propositionsRepository.save(propositions);
	}

	@Override
	public PropositionsModerationForm findForm(long id) {
		Propositions propositions = propositionsRepository.findOne(id);
		PropositionsModerationForm form = new PropositionsModerationForm();
//		form.setId(news.getId());
		form.setTheme(propositions.getTheme());
		form.setText(propositions.getText());
		form.setUserId(propositions.getId());
		form.setVersion(propositions.getVersion());
		return form;
	}

}

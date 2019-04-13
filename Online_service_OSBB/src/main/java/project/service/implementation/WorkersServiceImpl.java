package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.form.WorkersForm;
import project.entity.Workers;
import project.repository.WorkersRepository;
import project.service.WorkersService;

@Service
public class WorkersServiceImpl implements WorkersService{
	
	@Autowired
	private WorkersRepository workersRepository;

	@Override
	public List<Workers> findAll() {
		return workersRepository.findAll();
	}

	@Override
	public Workers findOne(int id) {
		return workersRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		workersRepository.delete(id);
	}

	@Override
	public void save(WorkersForm form) {
		Workers workers = new Workers();
		workers.setId(form.getId());
		workers.setPosition(form.getPosition());
		workers.setSurname(form.getSurname());
		workers.setName(form.getName());
		workers.setFathername(form.getFathername());
		workers.setPhoneWorker(form.getPhoneWorker());
		workers = workersRepository.saveAndFlush(workers);
		workersRepository.save(workers);
		
	}

	@Override
	public WorkersForm findForm(int id) {
		Workers workers = findOne(id);
		WorkersForm form = new WorkersForm();
		form.setId(workers.getId());
		form.setPosition(workers.getPosition());
		form.setSurname(workers.getSurname());
		form.setName(workers.getName());
		form.setFathername(workers.getFathername());
		form.setPhoneWorker(workers.getPhoneWorker());
		return form;
	}

}

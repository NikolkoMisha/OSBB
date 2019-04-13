package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.form.DebtorForm;
import project.entity.Debtor;
import project.repository.DebtorRepository;
import project.service.DebtorService;

@Service
public class DebtorServiceImpl implements DebtorService{

	@Autowired
	private DebtorRepository debtorRepository;

	@Override
	public List<Debtor> findAll() {
		return debtorRepository.findAll();
	}

	@Override
	public Debtor findOne(Long id) {
		return debtorRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		debtorRepository.delete(id);
	}

	@Override
	public void save(DebtorForm form) {
		Debtor debtor = new Debtor();
		debtor.setId(form.getId());
		debtor.setInfoName(form.getInfoName());
		debtor.setApartment(form.getApartment());
		debtor.setInfoSum(form.getInfoSum());
		debtor = debtorRepository.saveAndFlush(debtor);
		debtorRepository.save(debtor);
	}

	@Override
	public DebtorForm findForm(long id) {
		Debtor debtor = findOne(id);
		DebtorForm form = new DebtorForm();
		form.setId(debtor.getId());
		form.setInfoName(debtor.getInfoName());
		form.setApartment(debtor.getApartment());
		form.setInfoSum(debtor.getInfoSum());
		return form;
	}
	
	
	

}

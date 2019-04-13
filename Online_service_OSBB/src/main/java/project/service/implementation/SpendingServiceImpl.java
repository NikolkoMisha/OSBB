package project.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dto.form.SpendingForm;
import project.entity.Spending;
import project.repository.SpendingRepository;
import project.service.SpendingService;

@Service
public class SpendingServiceImpl implements SpendingService{

	@Autowired
	private SpendingRepository spendingRepository;
	
	@Override
	public List<Spending> findAll() {
		return spendingRepository.findAll();
	}

	@Override
	public Spending findOne(Long id) {
		return spendingRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		spendingRepository.delete(id);
	}

	@Override
	public void save(SpendingForm form) {
		Spending spending = new Spending();
		spending.setId(form.getId());
		spending.setName(form.getName());
		spending.setDate(form.getDate());
		spending.setPrice(new BigDecimal(form.getPrice().replace(',','.')));
		spending = spendingRepository.saveAndFlush(spending);
		spendingRepository.save(spending);
	}

	@Override
	@Transactional
	public SpendingForm findForm(long id) {
		Spending spending = findOne(id);
		SpendingForm form = new SpendingForm();
		form.setId(spending.getId());
		form.setName(spending.getName());
		form.setDate(spending.getDate());
		form.setPrice(String.valueOf(spending.getPrice()));
		return form;
	}
	
	
}

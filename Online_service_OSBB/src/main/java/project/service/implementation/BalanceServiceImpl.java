package project.service.implementation;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dto.form.BalanceForm;
import project.entity.Balance;
import project.repository.BalanceRepository;
import project.service.BalanceService;

@Service
public class BalanceServiceImpl implements BalanceService{

	@Autowired
	private BalanceRepository balanceRepository;
	
	@Override
	public List<Balance> findAll() {
		return balanceRepository.findAll();
	}

	@Override
	public Balance findOne(Long id) {
		return balanceRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		balanceRepository.delete(id);
	}

	@Override
	@Transactional
	public void save(BalanceForm  form){
		Balance balance = new Balance();
		balance.setId(form.getId());
		balance.setDate(form.getDate());
		balance.setPrice(new BigDecimal(form.getPrice().replace(',', '.')));
		balance = balanceRepository.saveAndFlush(balance);
		balanceRepository.save(balance);
	}
	
	@Override
	@Transactional
	public BalanceForm findForm(long id) {
		Balance balance = findOne(id);
		BalanceForm form = new BalanceForm();
		form.setId(balance.getId());
		form.setDate(balance.getDate());
		form.setPrice(String.valueOf(balance.getPrice()));
		return form;
	}

}

package project.service.implementation;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dto.form.TariffsForm;
import project.entity.Tariffs;
import project.repository.TariffsRepository;
import project.service.TariffsService;

@Service
public class TariffsServiceImpl implements TariffsService {

	@Autowired
	private TariffsRepository tariffsRepository;
	@Override
	public List<Tariffs> findAll() {
		return tariffsRepository.findAll();
	}

	@Override
	public Tariffs findOne(long id) {
		return tariffsRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		tariffsRepository.delete(id);
	}

	@Override
	public void save(TariffsForm form) {
		Tariffs tariffs = new Tariffs();
		tariffs.setId(form.getId());
		tariffs.setName(form.getName());
		tariffs.setPrice(new BigDecimal(form.getPrice().replace(',' ,'.')));
		tariffs = tariffsRepository.saveAndFlush(tariffs);
		tariffsRepository.save(tariffs);
	}

	@Override
	@Transactional
	public TariffsForm findForm(long id) {
		Tariffs tariffs = findOne(id);
		TariffsForm form = new TariffsForm();
		form.setId(tariffs.getId());
		form.setName(tariffs.getName());
		form.setPrice(String.valueOf(tariffs.getPrice()));
		return form;
	}

	@Override
	public Tariffs findByName(String name) {
		return tariffsRepository.findByHw(name);
	}

}

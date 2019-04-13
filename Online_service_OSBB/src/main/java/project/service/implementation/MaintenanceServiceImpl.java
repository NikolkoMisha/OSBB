package project.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dto.form.MaintenanceForm;
import project.entity.Maintenance;
import project.repository.MaintenanceRepository;
import project.service.MaintenanceService;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	private MaintenanceRepository maintenanceRepository;
	
	@Override
	public List<Maintenance> findAll() {
		return maintenanceRepository.findAll();
	}

	@Override
	public Maintenance findOne(Long id) {
		return maintenanceRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		maintenanceRepository.delete(id);
	}

	@Override
	public void save(MaintenanceForm form) {
		Maintenance maintenance = new Maintenance();
		maintenance.setId(form.getId());
		maintenance.setName(form.getName());
		maintenance.setPrice(new BigDecimal(form.getPrice().replace(',', '.')));
		maintenance = maintenanceRepository.saveAndFlush(maintenance);
		maintenanceRepository.save(maintenance);
	}

	@Override
	@Transactional
	public MaintenanceForm findForm(long id) {
		Maintenance maintenance = findOne(id);
		MaintenanceForm form = new MaintenanceForm();
		form.setId(maintenance.getId());
		form.setName(maintenance.getName());
		form.setPrice(String.valueOf(maintenance.getPrice()));
		return form;
	}

	@Override
	public Maintenance findByName(String name) {
		return maintenanceRepository.findByName(name);
	}
	
}

package project.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import project.dto.form.ReceiptsForm;
import project.entity.Receipts;

public interface ReceiptsService {

	List<Receipts> findAll();
	Receipts findOne(Long id);
//	void save(ReceiptsForm form, long id);
	List <Receipts> findByUserId(Principal principal);
//	ReceiptsForm findForm(long id);
	Page<Receipts> findByUserId(Principal principal, Pageable pageable);
	
	String findByMonth(String month);
	Integer findByYear(int year);
	void save(ReceiptsForm form, long id);
}

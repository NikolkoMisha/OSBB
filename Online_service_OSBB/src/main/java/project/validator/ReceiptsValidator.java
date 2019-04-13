package project.validator;



import java.time.Month;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import project.dto.form.ReceiptsForm;
import project.entity.Receipts;
import project.repository.ReceiptsRepository;
import project.service.ReceiptsService;

public class ReceiptsValidator implements Validator{

	private final ReceiptsService receiptService;
	
	
	public ReceiptsValidator(ReceiptsService receiptService) {
		this.receiptService = receiptService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ReceiptsForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ReceiptsForm form = (ReceiptsForm) target;
//		String month = receiptService.findByMonth(form.getMonth());
//		Integer year = receiptService.findByYear(form.getYear());
//		Receipts receipts = new Receipts();
//		if (receiptService.findByMonth(form.getMonth())!=null && receiptService.findByYear(form.getYear())!=null){
//			errors.rejectValue("month", "", "Вже існує");
//		}
		
	}

}

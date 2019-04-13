package project.service;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import project.dto.form.IndicatorsForm;
import project.entity.Indicators;

public interface IndicatorsService {

		List<Indicators> findAll();
		void delete(long id);
		Indicators findOne(long id);
		Indicators findByUserIndicators(String name);
//		Indicators findIndicatorsByUserId(long id);
		List<Indicators> findIndicatorsByUserId(long id);
		List<Indicators> findCurrentIndicatorsByUserId(long id);
		List<Indicators> findPreviousIndicatorsByUserId(long id);
		IndicatorsForm findByMonth(String month);
		IndicatorsForm findByYear(int year);
		IndicatorsForm findForm(long id);
		void save(IndicatorsForm form, Principal principal, String surname);
}

package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.dto.form.IndicatorsForm;
import project.entity.Indicators;

public interface IndicatorsRepository extends JpaRepository<Indicators, Long> {
	
	@Query("Select i FROM Indicators i WHERE i.name=?1")
	Indicators findByUserIndicators(String name);
	
//	@Query("SELECT i FROM Indicators i WHERE i.userId=?1 AND date=Month('2017-10-20')")
//	List<Indicators> findIndicatorsByUserId(Long id);
	
	@Query("SELECT i FROM Indicators i WHERE i.userId=?1 ORDER BY i.date DESC ")
	List<Indicators> findIndicatorsByUserId(Long id);

	IndicatorsForm findByMonth(String month);
	
	IndicatorsForm findByYear(int year);

}

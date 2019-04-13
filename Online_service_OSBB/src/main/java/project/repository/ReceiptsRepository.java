package project.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.dto.form.IndicatorsForm;
import project.dto.form.ReceiptsForm;
import project.entity.Receipts;

public interface ReceiptsRepository extends JpaRepository<Receipts, Long>{

	@Query("SELECT i FROM Receipts i WHERE i.userId=?1 ORDER by i.date DESC")
	List <Receipts> findByUserId(Long id);
	
	Page<Receipts> findByUserId(Long id, Pageable pageable);
	
	@Query("SELECT i FROM Receipts i WHERE i.month=?1 ORDER by i.date DESC")
	String findByMonth(String month);
//	
//	
	@Query("SELECT i FROM Receipts i WHERE i.year=?1 ORDER by i.date DESC")
	Integer findByYear(int year);
	
}

package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entity.Tariffs;

public interface TariffsRepository extends JpaRepository<Tariffs, Long> {

	@Query("SELECT name FROM Tariffs  WHERE name LIKE 'Гаряча вода'")
	Tariffs findByHw(String Hwater);

}

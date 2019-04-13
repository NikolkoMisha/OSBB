package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long>{

	Maintenance findByName(String name);

}

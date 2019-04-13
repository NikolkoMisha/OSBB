package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Spending;

public interface SpendingRepository extends JpaRepository<Spending, Long>{

}

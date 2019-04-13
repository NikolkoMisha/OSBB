package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Balance;

public interface BalanceRepository extends JpaRepository<Balance, Long>{

}

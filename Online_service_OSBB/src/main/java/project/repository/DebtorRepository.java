package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Debtor;

public interface DebtorRepository extends JpaRepository<Debtor, Long> {

}

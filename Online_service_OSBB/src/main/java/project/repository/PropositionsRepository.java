package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Propositions;

public interface PropositionsRepository extends JpaRepository<Propositions, Long> {

}

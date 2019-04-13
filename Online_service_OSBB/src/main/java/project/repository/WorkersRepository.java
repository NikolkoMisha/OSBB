package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Workers;

public interface WorkersRepository extends JpaRepository<Workers, Integer> {

}

package project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Attention;

public interface AttentionRepository extends JpaRepository<Attention, Long> {

}

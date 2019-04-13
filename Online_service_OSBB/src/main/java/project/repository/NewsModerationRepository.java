package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.NewsModeration;

public interface NewsModerationRepository extends JpaRepository<NewsModeration, Long>{

	
	
}

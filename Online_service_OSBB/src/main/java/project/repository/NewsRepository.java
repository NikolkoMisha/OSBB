package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entity.News;

public interface NewsRepository extends JpaRepository<News, Long>{
	
	@Query("SELECT i FROM News i WHERE i.id=?1")
	News findById(long id);
}

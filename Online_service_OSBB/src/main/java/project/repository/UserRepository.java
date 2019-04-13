package project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.login=?1")
	User findByLogin(String login);
	
	@Query("SELECT u  FROM User u WHERE u.email=?1")
	User findByEmail(String email);

	

}

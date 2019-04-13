package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

	@Query("SELECT u FROM UserInfo u WHERE u.surname=?1")
	UserInfo findBySurname(String surname);

}

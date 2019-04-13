package project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{


}

package project.service;

import java.security.Principal;
import java.util.List;

import project.dto.form.MessageForm;
import project.entity.Message;

public interface MessageService {

	List<Message> findAll();
	Message findOne(Long id);
	void delete(long id); 
	void save(MessageForm form, Principal principal);
//	MessageForm findForm(long id);
}

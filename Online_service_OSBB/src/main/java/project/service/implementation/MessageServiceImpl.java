package project.service.implementation;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.form.MessageForm;
import project.entity.Message;
import project.entity.User;
import project.repository.MessageRepository;
import project.repository.UserRepository;
import project.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	@Override
	public Message findOne(Long id) {
		return messageRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		messageRepository.delete(id);
	}
	
	@Override
	public void save(MessageForm form, Principal principal) {
		Message message = new Message();
		User user = userRepository.findByLogin(principal.getName());
		message.setId(form.getId());
		message.setMessage(form.getMessage());
		message.setUser(user.getSurname());
		message.setHour(form.getHour());
		message.setMinutes(form.getMinutes());
		message.setSeconds(form.getSeconds());
		message.setDate(form.getDate());
		message.setMonth(form.getMonth());
		message.setYear(form.getYear());
		message = messageRepository.saveAndFlush(message);
		messageRepository.save(message);
	}
	
	

}

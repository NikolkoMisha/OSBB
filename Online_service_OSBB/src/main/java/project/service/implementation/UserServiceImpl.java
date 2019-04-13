package project.service.implementation;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dto.ForgotPasswordEmail;
import project.dto.form.UserForm;
import project.dto.form.WorkersForm;
import project.entity.Role;
import project.entity.User;
import project.entity.Workers;
import project.repository.UserRepository;
//import project.service.FileWriter;
import project.service.UserService;
//import project.service.FileWriter.Folder;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
//	@Autowired
//	private FileWriter fileWriter;

	
	@Override
	public List<User> findAll() {
		List<User> user = userRepository.findAll();
			user.remove(0);
		return user;
	}
	

	@Override
	public User findOne(long id) {
		return userRepository.findOne(id);
	}
	
	
	@Override
	public void delete(long id) {
		userRepository.delete(id);
		
	}
	
	
	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		
		user.setRole(Role.ROLE_USER);
//		LocalDate date = LocalDate.now(Clock.systemUTC());
//		user.setDate(date);
		userRepository.save(user);
	}
	
	@PostConstruct
	public void addAdmin(){
		User user = userRepository.findByLogin("admin");
		if(user==null){
			user = new User();
			user.setLogin("admin");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			userRepository.save(user);
		}
	}

	
	@Override
	public User findByLogin(String username) {
		return userRepository.findByLogin(username);
	}

	@Override
	public User findByEmail(String email) {
		return  userRepository.findByEmail(email);
	}

	@Override
	public void adminsave(User admin) {
		admin.setPassword(encoder.encode(admin.getPassword()));
		admin.setRole(Role.ROLE_ADMIN);
		userRepository.save(admin);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByLogin(username);
	}
	
	@Override
	public long createNewUser() {
		return userRepository.saveAndFlush(new User()).getId();
	}


	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	@Override
	public String RandomNumber(String randomNumber) {
		int a = 0;
		int b = 10;
		int random_number1 = a + (int) (Math.random() * b);
		int random_number2 = a + (int) (Math.random() * b);
		int random_number3 = a + (int) (Math.random() * b);
		int random_number4 = a + (int) (Math.random() * b);
		int random_number5 = a + (int) (Math.random() * b);
		int random_number6 = a + (int) (Math.random() * b);
		randomNumber = String.valueOf(random_number1+random_number2+random_number3+random_number4+random_number5+random_number6);
		return randomNumber;
	}
	
	
	
	@Override
	public void ResetPassword(User form) {
		userRepository.save(form);
		
	}
	
	public void sendMail(String content, String email, String mailBody) {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties,
		new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("mishan9sova@Gmail.com", "Yamahaxj9");
		}
		});
		
		try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("mishan9sova@Gmail.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
		email));
		message.setSubject(content, "UTF-8");
		message.setText(mailBody);
		Transport.send(message);
		} catch (MessagingException е) {
		е.printStackTrace();
		}
	}

	
	
	
	
//	@Override
//	public UserForm findForm(long id) {
//		User user = findOne(id);
//		UserForm form = new UserForm();
//		LocalDate date = LocalDate.now(Clock.systemUTC());
//		form.setId(user.getId());
//		form.setEmail(user.getEmail());
//		form.setName(user.getName());
//		form.setLastname(user.getLastname());
//		form.setSurname(user.getSurname());
//		form.setPasswordduplicat(user.getPasswordduplicat());
//		form.setInitials(user.getInitials());
//		form.setPrivileges(String.valueOf(user.getPrivileges()));
//		form.setFlatArea(String.valueOf(user.getFlatArea()));
//		form.setFlatAreaDebt(String.valueOf(user.getFlatAreaDebt()));
//		form.sethMaintenanceDebt(String.valueOf(user.gethMaintenanceDebt()));
//		form.sethWaterDebt(String.valueOf(user.gethWaterDebt()));
//		form.setcWaterDebt(String.valueOf(user.getcWaterDebt()));
//		form.setHeatingDebt(String.valueOf(user.getHeatingDebt()));
//		form.setPersonalAccount(user.getPersonalAccount());
//		form.setAddress(user.getAddress());
//		form.setTurn(user.getTurn());
//		form.setCountTenant(user.getCountTenant());
//		form.setDate(date);
//		form.setApartment(user.getApartment());
//		form.setPhone(user.getPhone());
//		form.setLogin(user.getLogin());
//		return form;
//	}
	
//	@Override
//	public UserForm findForm(long id) {
//		User user = findOne(id);
//		UserForm form = new UserForm();
//		LocalDate date = LocalDate.now(Clock.systemUTC());
//		form.setId(user.getId());
//		form.setEmail(user.getEmail());
//		form.setName(user.getName());
//		form.setLastname(user.getLastname());
//		form.setSurname(user.getSurname());
////		form.setInitials(user.getInitials());
////		form.setPrivileges(String.valueOf(user.getPrivileges()));
////		form.setFlatArea(String.valueOf(user.getFlatArea()));
////		form.setFlatAreaDebt(String.valueOf(user.getFlatAreaDebt()));
////		form.sethMaintenanceDebt(String.valueOf(user.gethMaintenanceDebt()));
////		form.sethWaterDebt(String.valueOf(user.gethWaterDebt()));
////		form.setcWaterDebt(String.valueOf(user.getcWaterDebt()));
////		form.setHeatingDebt(String.valueOf(user.getHeatingDebt()));
////		form.setPersonalAccount(user.getPersonalAccount());
////		form.setAddress(user.getAddress());
////		form.setTurn(user.getTurn());
////		form.setCountTenant(user.getCountTenant());
//		form.setDate(date);
//		form.setApartment(user.getApartment());
//		form.setPhone(user.getPhone());
//		form.setLogin(user.getLogin());
//		return form;
//	}




	
}
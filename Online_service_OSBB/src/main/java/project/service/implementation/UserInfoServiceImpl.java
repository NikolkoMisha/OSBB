package project.service.implementation;

import java.util.List;

import javax.annotation.PostConstruct;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.Clock;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dto.form.UserInfoForm;
import project.dto.form.WorkersForm;
import project.entity.User;
import project.entity.UserInfo;
import project.entity.Workers;
import project.repository.UserInfoRepository;
import project.repository.UserRepository;
import project.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserInfo> findAll() {
//		List<UserInfo> userInfo = userInfoRepository.findAll();
//		userInfo.remove(0);
		return userInfoRepository.findAll();
	}
	

	@Override
	public UserInfo findOne(Long id) {
		return userInfoRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		userInfoRepository.delete(id);
	}
	
//	@PostConstruct
//	public void addAdmin(){
//		UserInfo userInfo = userInfoRepository.findByInitials("Admin");
//		
//				if(userInfo==null){
//					userInfo = new UserInfo();
//					userInfo.setInitials("Ініціали");
//					userInfoRepository.save(userInfo);
//				}
//				if(userInfo.getId()==1){
//					userInfo = new UserInfo();
//					userInfo.setInitials("Ініціали");
//					userInfoRepository.save(userInfo);
//				}
//				
//			
//	}
	public void saveR(UserInfoForm form){
		UserInfo userInfo = new UserInfo();
		LocalDate date = LocalDate.now(Clock.systemUTC());
		userInfo.setId(form.getId());
		userInfo.setSurname(form.getSurname());
		userInfo.setName(form.getName());
		userInfo.setLastname(form.getLastname());
		userInfo.setApartment(form.getApartment());
		userInfo.setEmail(form.getEmail());
		userInfo.setPhone(form.getPhone());
		userInfo.setDate(date);
		userInfo.setFlatArea(new BigDecimal(0));
		userInfo.setFlatAreaDebt(new BigDecimal(0));
		userInfo.sethMaintenanceDebt(new BigDecimal(0));
		userInfo.sethWaterDebt(new BigDecimal(0));
		userInfo.setcWaterDebt(new BigDecimal(0));
		userInfo.setHeatingDebt(new BigDecimal(0));
		userInfo.setPrivileges(new BigDecimal(0));
		userInfo = userInfoRepository.saveAndFlush(userInfo);
		userInfoRepository.save(userInfo);
	}
	
	

	@Override
	public void save(UserInfoForm form) {
		UserInfo userInfo = new UserInfo();
		LocalDate date = LocalDate.now(Clock.systemUTC());
		userInfo.setId(form.getId());
		userInfo.setSurname(form.getSurname());
		userInfo.setName(form.getName());
		userInfo.setLastname(form.getLastname());
		userInfo.setApartment(form.getApartment());
		userInfo.setEmail(form.getEmail());
		userInfo.setPhone(form.getPhone());
		userInfo.setInitials(form.getInitials());
		userInfo.setFlatArea(new BigDecimal(form.getFlatArea().replace(',' , '.')));
		userInfo.setPrivileges(new BigDecimal(form.getPrivileges().replace(',' , '.')).divide(new BigDecimal(100)));
		userInfo.setFlatAreaDebt(new BigDecimal(form.getFlatAreaDebt().replace(',' , '.')));
		userInfo.sethMaintenanceDebt(new BigDecimal(form.gethMaintenanceDebt().replace(',' , '.')));
		userInfo.sethWaterDebt(new BigDecimal(form.gethWaterDebt().replace(',' , '.')));
		userInfo.setcWaterDebt(new BigDecimal(form.getcWaterDebt().replace(',' , '.')));
		userInfo.setHeatingDebt(new BigDecimal(form.getHeatingDebt().replace(',' , '.')));
		userInfo.setPersonalAccount(form.getPersonalAccount());
		userInfo.setAddress(form.getAddress());
		userInfo.setTurn(form.getTurn());
		userInfo.setCountTenant(form.getCountTenant());
		userInfo.setDate(date);
		userInfo = userInfoRepository.saveAndFlush(userInfo);
		userInfoRepository.save(userInfo);
	}	
	
	@Override
	public UserInfoForm findForm(long id) {
		UserInfo userInfo = findOne(id);
		UserInfoForm form = new UserInfoForm();
		LocalDate date = LocalDate.now(Clock.systemUTC());
		form.setId(userInfo.getId());
		form.setSurname(userInfo.getSurname());
		form.setName(userInfo.getName());
		form.setLastname(userInfo.getLastname());
		form.setApartment(userInfo.getApartment());
		form.setEmail(userInfo.getEmail());
		form.setInitials(userInfo.getInitials());
		form.setPrivileges(String.valueOf(userInfo.getPrivileges()));
		form.setFlatArea(String.valueOf(userInfo.getFlatArea()));
		form.setFlatAreaDebt(String.valueOf(userInfo.getFlatAreaDebt()));
		form.sethMaintenanceDebt(String.valueOf(userInfo.gethMaintenanceDebt()));
		form.sethWaterDebt(String.valueOf(userInfo.gethWaterDebt()));
		form.setcWaterDebt(String.valueOf(userInfo.getcWaterDebt()));
		form.setHeatingDebt(String.valueOf(userInfo.getHeatingDebt()));
		form.setPersonalAccount(userInfo.getPersonalAccount());
		form.setAddress(userInfo.getAddress());
		form.setTurn(userInfo.getTurn());
		form.setCountTenant(userInfo.getCountTenant());
		form.setPhone(userInfo.getPhone());
		form.setDate(date);
		return form;
	}


	@Override
	public UserInfo findBySurname(String surname, Principal principal) {
		User user = userRepository.findByLogin(principal.getName());
		return userInfoRepository.findBySurname(user.getSurname());
	}




}

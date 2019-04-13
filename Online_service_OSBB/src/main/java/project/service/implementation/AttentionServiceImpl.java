package project.service.implementation;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dto.form.AttentionForm;
import project.entity.Attention;
import project.entity.UserInfo;
import project.repository.AttentionRepository;
import project.service.AttentionService;
import project.service.FileWriter;
import project.service.FileWriter.Folder;
import project.service.UserInfoService;

@Service
public class AttentionServiceImpl implements AttentionService {

	@Autowired
	private AttentionRepository attentionRepository;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public List<Attention> findAll() {
		List<Attention> reverse = attentionRepository.findAll();
		Collections.reverse(reverse);
		return reverse;
	}

	@Override
	public Attention findOne(Long id) {
		return attentionRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		attentionRepository.delete(id);
	}

	@Override
	@Transactional
	public void save(AttentionForm form, String surname ,Principal principal) {
		Attention attention = new Attention();
		LocalDate localdate = LocalDate.now(ZoneId.of("Europe/Kiev"));
		UserInfo userInfo = userInfoService.findBySurname(surname, principal);
		Date date = new Date();
		attention.setId(form.getId());
		attention.setTheme(form.getTheme());
		attention.setText(form.getText());
		attention.setPublisher(userInfo.getInitials());
		attention.setDate(localdate);
		attention.setDay(date.getDate());
		if(date.getMonth()==0){
			String month = "Січня";
			attention.setMonth(month);
		}
		if(date.getMonth()==1){
			String month = "Лютого";
			attention.setMonth(month);
		}
		if(date.getMonth()==2){
			String month = "Березня";
			attention.setMonth(month);
		}
		if(date.getMonth()==3){
			String month = "Квітня";
			attention.setMonth(month);
		}
		if(date.getMonth()==4){
			String month = "Травня";
			attention.setMonth(month);
		}
		if(date.getMonth()==5){
			String month = "Червня";
			attention.setMonth(month);
		}
		if(date.getMonth()==6){
			String month = "Липня";
			attention.setMonth(month);
		}
		if(date.getMonth()==7){
			String month = "Серпня";
			attention.setMonth(month);
		}
		if(date.getMonth()==8){
			String month = "Вересня";
			attention.setMonth(month);
		}
		if(date.getMonth()==9){
			String month = "Жовтня";
			attention.setMonth(month);
		}
		if(date.getMonth()==10){
			String month = "Листопада";
			attention.setMonth(month);
		}
		if(date.getMonth()==11){
			String month = "Грудня";
			attention.setMonth(month);
		}
		attention.setYear(1900+date.getYear());
		
		attention = attentionRepository.saveAndFlush(attention);
		if(fileWriter.write(Folder.ATTENTION, form.getFile(), attention.getId())){
			if(attention.getVersion()==null)attention.setVersion(0);
			else attention.setVersion(attention.getVersion()+1);}
		attentionRepository.save(attention);
	}



}

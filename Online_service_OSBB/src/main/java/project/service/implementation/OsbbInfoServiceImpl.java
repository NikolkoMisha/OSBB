package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.form.OsbbInfoForm;
import project.entity.OsbbInfo;
import project.repository.OsbbInfoRepository;
import project.service.FileWriter;
import project.service.OsbbInfoService;
import project.service.FileWriter.Folder;

@Service
public class OsbbInfoServiceImpl implements OsbbInfoService{
	
	@Autowired
	private OsbbInfoRepository osbbInfoRepository;

	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public List<OsbbInfo> findAll() {
		return osbbInfoRepository.findAll();
	}

	@Override
	public OsbbInfo findOne(Long id) {
		return osbbInfoRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		osbbInfoRepository.delete(id);
	}

	@Override
	public void save(OsbbInfoForm form) {
		OsbbInfo info = new OsbbInfo();
		info.setId(form.getId());
		info.setOsbbName(form.getOsbbName());
		info.seteDRPOU(form.geteDRPOU());
		info.setBankScore(form.getBankScore());
		info.setBankName(form.getBankName());
		info.setBankDetails(form.getBankDetails());
		info.setAddress(form.getAddress());
		info.setfName(form.getfName());
		info.setPhoneOSBB(form.getPhoneOSBB());
		info.setWorkSchedule(form.getWorkSchedule());
		info = osbbInfoRepository.saveAndFlush(info);
		if(fileWriter.write(Folder.OSBBINFO, form.getFile(), info.getId())){
		if(info.getVersion()==null)info.setVersion(0);
		else info.setVersion(info.getVersion()+1);}
		osbbInfoRepository.save(info);
	}



	@Override
	public OsbbInfoForm findForm(long id) {
		OsbbInfo info = osbbInfoRepository.findOne(id);
		OsbbInfoForm form = new OsbbInfoForm();
		form.setId(info.getId());
		form.setOsbbName(info.getOsbbName());
		form.seteDRPOU(info.geteDRPOU());
		form.setBankScore(info.getBankScore());
		form.setBankName(info.getBankName());
		form.setBankDetails(info.getBankDetails());
		form.setAddress(info.getAddress());
		form.setfName(info.getfName());
		form.setPhoneOSBB(info.getPhoneOSBB());
		form.setWorkSchedule(info.getWorkSchedule());
		return form;
	}

}

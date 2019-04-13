package project.dto.form;

import org.springframework.web.multipart.MultipartFile;

public class OsbbInfoForm {

	
	private long id;
	private String osbbName;
	private String eDRPOU;
	private String bankScore;
	private String bankName;
	private String bankDetails;
	private String address;
	
	
	private String fName;
	private String phoneOSBB;
	private String workSchedule;
	
	private MultipartFile file;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOsbbName() {
		return osbbName;
	}

	public void setOsbbName(String osbbName) {
		this.osbbName = osbbName;
	}

	public String geteDRPOU() {
		return eDRPOU;
	}

	public void seteDRPOU(String eDRPOU) {
		this.eDRPOU = eDRPOU;
	}

	public String getBankScore() {
		return bankScore;
	}

	public void setBankScore(String bankScore) {
		this.bankScore = bankScore;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getPhoneOSBB() {
		return phoneOSBB;
	}

	public void setPhoneOSBB(String phoneOSBB) {
		this.phoneOSBB = phoneOSBB;
	}

	public String getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(String workSchedule) {
		this.workSchedule = workSchedule;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
}

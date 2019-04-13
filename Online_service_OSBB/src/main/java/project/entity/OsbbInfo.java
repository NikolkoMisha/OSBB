package project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="OsbbInfo")
public class OsbbInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="osbbName")
	private String osbbName;
	@Column(name="EDRPOU")
	private String eDRPOU;
	@Column(name="curentAccount")
	private String bankScore;
	@Column(name="bankName")
	private String bankName;
	@Column(name="bankDetails")
	private String bankDetails;
	@Column(name="address")
	private String address;
	
	
	@Column(name="ful_name")
	private String fName;
	@Column(name="phoneOSBB")
	private String phoneOSBB;
	@Column(name="work_schedule")
	private String workSchedule;
	
	private Integer version;
	@Transient
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}

package project.dto.form;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WorkersForm {


	private int id;
	private String position;
	private String name;
	private String surname;
	private String fathername;
	private String phoneWorker;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getPhoneWorker() {
		return phoneWorker;
	}
	public void setPhoneWorker(String phoneWorker) {
		this.phoneWorker = phoneWorker;
	}
	
	
	
}

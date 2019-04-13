package project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workers")
public class Workers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="position")
	private String position;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="fathername")
	private String fathername;
	@Column(name="phone")
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

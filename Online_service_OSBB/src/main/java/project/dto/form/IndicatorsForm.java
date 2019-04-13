package project.dto.form;

import java.sql.Date;

import javax.persistence.Column;

public class IndicatorsForm {
	
	private long id;
	private String Hwater;
	private String Cwater;
	private String heating;
	private String name;
	private String surname;
	private String month;
	private int year;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHwater() {
		return Hwater;
	}
	public void setHwater(String hwater) {
		Hwater = hwater;
	}
	public String getCwater() {
		return Cwater;
	}
	public void setCwater(String cwater) {
		Cwater = cwater;
	}
	public String getHeating() {
		return heating;
	}
	public void setHeating(String heating) {
		this.heating = heating;
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	

}

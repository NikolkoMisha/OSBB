package project.dto.form;

import java.time.LocalDate;

public class UserForm {

	private long id;
	private String email;
	private String name;
	private String passwordduplicat;
	private String lastname;
	private String surname;
	private String initials;//Прізвище І.П.
	private String flatArea;
	private String privileges;
	private String flatAreaDebt;
	private String hMaintenanceDebt;
	private String hWaterDebt;
	private String cWaterDebt;
	private String heatingDebt;
	private String personalAccount;
	private String address;
	private String turn;
	private String countTenant;

	private LocalDate date;
	private String apartment;
	private String phone;
	private String login;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswordduplicat() {
		return passwordduplicat;
	}
	public void setPasswordduplicat(String passwordduplicat) {
		this.passwordduplicat = passwordduplicat;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public String getFlatArea() {
		return flatArea;
	}
	public void setFlatArea(String flatArea) {
		this.flatArea = flatArea;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	public String getFlatAreaDebt() {
		return flatAreaDebt;
	}
	public void setFlatAreaDebt(String flatAreaDebt) {
		this.flatAreaDebt = flatAreaDebt;
	}
	public String gethMaintenanceDebt() {
		return hMaintenanceDebt;
	}
	public void sethMaintenanceDebt(String hMaintenanceDebt) {
		this.hMaintenanceDebt = hMaintenanceDebt;
	}
	public String gethWaterDebt() {
		return hWaterDebt;
	}
	public void sethWaterDebt(String hWaterDebt) {
		this.hWaterDebt = hWaterDebt;
	}
	public String getcWaterDebt() {
		return cWaterDebt;
	}
	public void setcWaterDebt(String cWaterDebt) {
		this.cWaterDebt = cWaterDebt;
	}
	public String getHeatingDebt() {
		return heatingDebt;
	}
	public void setHeatingDebt(String heatingDebt) {
		this.heatingDebt = heatingDebt;
	}
	public String getPersonalAccount() {
		return personalAccount;
	}
	public void setPersonalAccount(String personalAccount) {
		this.personalAccount = personalAccount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTurn() {
		return turn;
	}
	public void setTurn(String turn) {
		this.turn = turn;
	}
	public String getCountTenant() {
		return countTenant;
	}
	public void setCountTenant(String countTenant) {
		this.countTenant = countTenant;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
	
	
	
}

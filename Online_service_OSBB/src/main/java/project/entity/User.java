	package project.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
public class User implements UserDetails{

	private static final long serialVersionUID = 2624412028011269262L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String name;
	private String surname;
	private String lastname;
	private String apartment;
	private String phone;
	private String login;
	private String password;
//	@Column(name="initials")
//	private String initials;//Прізвище І.П.
//	@Column(name="flatArea")
//	private BigDecimal flatArea;
//	@Column(name="privileges")
//	private BigDecimal privileges;
//	@Column(name="flatArea_Debt")
//	private BigDecimal flatAreaDebt;
//	@Column(name="hMiantenance_Debt")
//	private BigDecimal hMaintenanceDebt;
//	@Column(name="hWater_Debt")
//	private BigDecimal hWaterDebt;
//	@Column(name="cWater_Debt")
//	private BigDecimal cWaterDebt;
//	@Column(name="heating_Debt")
//	private BigDecimal heatingDebt;
//	@Column(name="personal_Account")
//	private String personalAccount;
//	@Column(name="address")
//	private String address;
//	@Column(name="turn")
//	private String turn;
//	@Column(name="count_Tenant")
//	private String countTenant;
//	@Column(name="date")
//	private LocalDate date;
	private String secret;
	
//	private Integer version;
//	@Transient
//	private MultipartFile file;
	
	@Enumerated
	@Column(name="_role")
	private Role role;


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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(role.name()));
		return list;
	}
	@Override
	public String getUsername() {
		return login;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
//	public String getInitials() {
//		return initials;
//	}
//	public void setInitials(String initials) {
//		this.initials = initials;
//	}
//	public BigDecimal getFlatArea() {
//		return flatArea;
//	}
//	public void setFlatArea(BigDecimal flatArea) {
//		this.flatArea = flatArea;
//	}
//	public BigDecimal getPrivileges() {
//		return privileges;
//	}
//	public void setPrivileges(BigDecimal privileges) {
//		this.privileges = privileges;
//	}
//	public BigDecimal getFlatAreaDebt() {
//		return flatAreaDebt;
//	}
//	public void setFlatAreaDebt(BigDecimal flatAreaDebt) {
//		this.flatAreaDebt = flatAreaDebt;
//	}
//	public BigDecimal gethMaintenanceDebt() {
//		return hMaintenanceDebt;
//	}
//	public void sethMaintenanceDebt(BigDecimal hMaintenanceDebt) {
//		this.hMaintenanceDebt = hMaintenanceDebt;
//	}
//	public BigDecimal gethWaterDebt() {
//		return hWaterDebt;
//	}
//	public void sethWaterDebt(BigDecimal hWaterDebt) {
//		this.hWaterDebt = hWaterDebt;
//	}
//	public BigDecimal getcWaterDebt() {
//		return cWaterDebt;
//	}
//	public void setcWaterDebt(BigDecimal cWaterDebt) {
//		this.cWaterDebt = cWaterDebt;
//	}
//	public BigDecimal getHeatingDebt() {
//		return heatingDebt;
//	}
//	public void setHeatingDebt(BigDecimal heatingDebt) {
//		this.heatingDebt = heatingDebt;
//	}
//	public String getPersonalAccount() {
//		return personalAccount;
//	}
//	public void setPersonalAccount(String personalAccount) {
//		this.personalAccount = personalAccount;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getTurn() {
//		return turn;
//	}
//	public void setTurn(String turn) {
//		this.turn = turn;
//	}
//	public String getCountTenant() {
//		return countTenant;
//	}
//	public void setCountTenant(String countTenant) {
//		this.countTenant = countTenant;
//	}
//	public LocalDate getDate() {
//		return date;
//	}
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
	

}

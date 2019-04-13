package project.entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="indicators") // 
public class Indicators {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(name="flat_area")
		private BigDecimal flatArea;
		@Column(name="home_maintenance")
		private BigDecimal homeMaintenance;
		@Column(name="Hwater")// H - hot_water
		private BigDecimal hwater;
		@Column(name="Cwater")// C - cold_water
		private BigDecimal cwater;
		@Column(name="heating")
		private BigDecimal heating;
		@Column(name="date")
		private LocalDate date;
		@Column(name="month")
		private String month;
		@Column(name="year")
		private int year;
		
		@Column(name="userId")
		private long userId;
		@Column(name="name")
		private String name;
		@Column(name="surname")// ім'я мешканця
		private String surname;
		@Column(name="apartment")
		private String apartment;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public BigDecimal getFlatArea() {
			return flatArea;
		}

		public void setFlatArea(BigDecimal flatArea) {
			this.flatArea = flatArea;
		}

		public BigDecimal getHomeMaintenance() {
			return homeMaintenance;
		}

		public void setHomeMaintenance(BigDecimal homeMaintenance) {
			this.homeMaintenance = homeMaintenance;
		}
		
		public LocalDate getDate() {
			return date;
		}

		public BigDecimal getHwater() {
			return hwater;
		}

		public void setHwater(BigDecimal hwater) {
			this.hwater = hwater;
		}

		public BigDecimal getCwater() {
			return cwater;
		}

		public void setCwater(BigDecimal cwater) {
			this.cwater = cwater;
		}

		public BigDecimal getHeating() {
			return heating;
		}

		public void setHeating(BigDecimal heating) {
			this.heating = heating;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
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

		public String getApartment() {
			return apartment;
		}

		public void setApartment(String apartment) {
			this.apartment = apartment;
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

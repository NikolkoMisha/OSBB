package project.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="receipts")
public class Receipts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="userId")
	private long userId;
	@Column(name="date")
	private LocalDate date;
	
// Показники
	@Column(name="Hwater")// H - hot_water
	private BigDecimal hWater;
	@Column(name="Cwater")// C - cold_water
	private BigDecimal cWater;
	@Column(name="heating")
	private BigDecimal heating;
	@Column(name="flat_area")
	private BigDecimal area;
	@Column(name="home_maintenance")
	private BigDecimal homeMaintenance;
	
// Тарифи - назва	
	@Column(name="Stariffs_Hwater")
	private String tariffsHwString;
	@Column(name="Stariffs_Сwater")
	private String tariffsСwString;
	@Column(name="Stariffs_heating")
	private String tariffsHeatingString;
	@Column(name="Stariffs_flat_area")
	private String tariffsFlatAreaString;
	@Column(name="Stariffs_home_maintenance")
	private String tariffsHomeMaintenanceString;
	
// Тарифи - ціни	
	@Column(name="tariffs_Hwater")
	private BigDecimal tariffsHw;
	@Column(name="tariffs_Сwater")
	private BigDecimal tariffsСw;
	@Column(name="tariffs_heating")
	private BigDecimal tariffsHeating;
	@Column(name="tariffs_flat_area")
	private BigDecimal tariffsFlatArea;
	@Column(name="tariffs_home_maintenance")
	private BigDecimal tariffsHomeMaintenance;
	
// Пільга
	@Column(name="privileges_flat_area")
	private BigDecimal privilegesArea;
	@Column(name="privileges_home_maintenance")
	private BigDecimal privilegesHomeM;
	@Column(name="privileges_Hwater")
	private BigDecimal privilegesHw;
	@Column(name="privileges_Cwater")
	private BigDecimal privilegesCw;
	@Column(name="privileges_heating")
	private BigDecimal privilegesHeating;
	@Column(name="privilegesTotalSum")
	private BigDecimal privilegesTotalSum;
	
// Борг
	@Column(name="flatAreaDebt")
	private BigDecimal areaDebt;
	@Column(name="hMaintenance")
	private BigDecimal maintenanceDebt;
	@Column(name="hWaterDebt")
	private BigDecimal hWaterDebt;
	@Column(name="cWaterDebt")
	private BigDecimal cWaterDebt;
	@Column(name="heatingDebt")
	private BigDecimal heatingDebt;
	@Column(name="totalSumDebt")
	private BigDecimal totalSumDebt;
	
// Нараховано
	@Column(name="sumArea")
	private BigDecimal sumArea;
	@Column(name="sumMaintenance")
	private BigDecimal sumMaintenance;
	@Column(name="sumHwater")
	private BigDecimal sumHwater;
	@Column(name="sumCwater")
	private BigDecimal sumCwater;
	@Column(name="sumHeating")
	private BigDecimal sumHeating;
	@Column(name="totalSum")
	private BigDecimal totalSum;
	
// фінальна сума (РАЗОМ) 
	@Column(name="finalSumArea")
	private BigDecimal finalSumArea;
	@Column(name="finalSumMaintenance")
	private BigDecimal finalSumMaintenance;
	@Column(name="finalSumHwater")
	private BigDecimal finalSumHwater;
	@Column(name="finalSumCwater")
	private BigDecimal finalSumCwater;
	@Column(name="finalSumHeating")
	private BigDecimal finalSumHeating;
	@Column(name="totalFinalSum")
	private BigDecimal totalFinalSum;
	
//  Дата за який місяць квитанція видається (те шо вгорі)
	@Column(name="month")
	private String month;
	@Column(name="year")
	private int year;
	
//  Попередні показники
	@Column(name="PreviousHwater")// H - hot_water
	private BigDecimal previousHwater;
	@Column(name="PreviousCwater")// C - cold_water
	private BigDecimal previousCwater;
	@Column(name="Previousheating")
	private BigDecimal previousHeating;
	
//	Поточні показники
	@Column(name="CurrentHwater")// H - hot_water
	private BigDecimal currentHwater;
	@Column(name="CurrentCwater")// C - cold_water
	private BigDecimal currentCwater;
	@Column(name="Currentheating")
	private BigDecimal currentHeating;

// Реквізити отримувача
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public BigDecimal gethWater() {
		return hWater;
	}
	public void sethWater(BigDecimal hWater) {
		this.hWater = hWater;
	}
	public BigDecimal getcWater() {
		return cWater;
	}
	public void setcWater(BigDecimal cWater) {
		this.cWater = cWater;
	}
	public BigDecimal getHeating() {
		return heating;
	}
	public void setHeating(BigDecimal heating) {
		this.heating = heating;
	}
	public BigDecimal getArea() {
		return area;
	}
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	public BigDecimal getHomeMaintenance() {
		return homeMaintenance;
	}
	public void setHomeMaintenance(BigDecimal homeMaintenance) {
		this.homeMaintenance = homeMaintenance;
	}
	public String getTariffsHwString() {
		return tariffsHwString;
	}
	public void setTariffsHwString(String tariffsHwString) {
		this.tariffsHwString = tariffsHwString;
	}
	public String getTariffsСwString() {
		return tariffsСwString;
	}
	public void setTariffsСwString(String tariffsСwString) {
		this.tariffsСwString = tariffsСwString;
	}
	public String getTariffsHeatingString() {
		return tariffsHeatingString;
	}
	public void setTariffsHeatingString(String tariffsHeatingString) {
		this.tariffsHeatingString = tariffsHeatingString;
	}
	public String getTariffsFlatAreaString() {
		return tariffsFlatAreaString;
	}
	public void setTariffsFlatAreaString(String tariffsFlatAreaString) {
		this.tariffsFlatAreaString = tariffsFlatAreaString;
	}
	public String getTariffsHomeMaintenanceString() {
		return tariffsHomeMaintenanceString;
	}
	public void setTariffsHomeMaintenanceString(String tariffsHomeMaintenanceString) {
		this.tariffsHomeMaintenanceString = tariffsHomeMaintenanceString;
	}
	public BigDecimal getTariffsHw() {
		return tariffsHw;
	}
	public void setTariffsHw(BigDecimal tariffsHw) {
		this.tariffsHw = tariffsHw;
	}
	public BigDecimal getTariffsСw() {
		return tariffsСw;
	}
	public void setTariffsСw(BigDecimal tariffsСw) {
		this.tariffsСw = tariffsСw;
	}
	public BigDecimal getTariffsHeating() {
		return tariffsHeating;
	}
	public void setTariffsHeating(BigDecimal tariffsHeating) {
		this.tariffsHeating = tariffsHeating;
	}
	public BigDecimal getTariffsFlatArea() {
		return tariffsFlatArea;
	}
	public void setTariffsFlatArea(BigDecimal tariffsFlatArea) {
		this.tariffsFlatArea = tariffsFlatArea;
	}
	public BigDecimal getTariffsHomeMaintenance() {
		return tariffsHomeMaintenance;
	}
	public void setTariffsHomeMaintenance(BigDecimal tariffsHomeMaintenance) {
		this.tariffsHomeMaintenance = tariffsHomeMaintenance;
	}
	public BigDecimal getPrivilegesArea() {
		return privilegesArea;
	}
	public void setPrivilegesArea(BigDecimal privilegesArea) {
		this.privilegesArea = privilegesArea;
	}
	public BigDecimal getPrivilegesHomeM() {
		return privilegesHomeM;
	}
	public void setPrivilegesHomeM(BigDecimal privilegesHomeM) {
		this.privilegesHomeM = privilegesHomeM;
	}
	public BigDecimal getPrivilegesHw() {
		return privilegesHw;
	}
	public void setPrivilegesHw(BigDecimal privilegesHw) {
		this.privilegesHw = privilegesHw;
	}
	public BigDecimal getPrivilegesCw() {
		return privilegesCw;
	}
	public void setPrivilegesCw(BigDecimal privilegesCw) {
		this.privilegesCw = privilegesCw;
	}
	public BigDecimal getPrivilegesHeating() {
		return privilegesHeating;
	}
	public void setPrivilegesHeating(BigDecimal privilegesHeating) {
		this.privilegesHeating = privilegesHeating;
	}
	public BigDecimal getPrivilegesTotalSum() {
		return privilegesTotalSum;
	}
	public void setPrivilegesTotalSum(BigDecimal privilegesTotalSum) {
		this.privilegesTotalSum = privilegesTotalSum;
	}
	public BigDecimal getAreaDebt() {
		return areaDebt;
	}
	public void setAreaDebt(BigDecimal areaDebt) {
		this.areaDebt = areaDebt;
	}
	public BigDecimal getMaintenanceDebt() {
		return maintenanceDebt;
	}
	public void setMaintenanceDebt(BigDecimal maintenanceDebt) {
		this.maintenanceDebt = maintenanceDebt;
	}
	public BigDecimal gethWaterDebt() {
		return hWaterDebt;
	}
	public void sethWaterDebt(BigDecimal hWaterDebt) {
		this.hWaterDebt = hWaterDebt;
	}
	public BigDecimal getcWaterDebt() {
		return cWaterDebt;
	}
	public void setcWaterDebt(BigDecimal cWaterDebt) {
		this.cWaterDebt = cWaterDebt;
	}
	public BigDecimal getHeatingDebt() {
		return heatingDebt;
	}
	public void setHeatingDebt(BigDecimal heatingDebt) {
		this.heatingDebt = heatingDebt;
	}
	public BigDecimal getTotalSumDebt() {
		return totalSumDebt;
	}
	public void setTotalSumDebt(BigDecimal totalSumDebt) {
		this.totalSumDebt = totalSumDebt;
	}
	public BigDecimal getSumArea() {
		return sumArea;
	}
	public void setSumArea(BigDecimal sumArea) {
		this.sumArea = sumArea;
	}
	public BigDecimal getSumMaintenance() {
		return sumMaintenance;
	}
	public void setSumMaintenance(BigDecimal sumMaintenance) {
		this.sumMaintenance = sumMaintenance;
	}
	public BigDecimal getSumHwater() {
		return sumHwater;
	}
	public void setSumHwater(BigDecimal sumHwater) {
		this.sumHwater = sumHwater;
	}
	public BigDecimal getSumCwater() {
		return sumCwater;
	}
	public void setSumCwater(BigDecimal sumCwater) {
		this.sumCwater = sumCwater;
	}
	public BigDecimal getSumHeating() {
		return sumHeating;
	}
	public void setSumHeating(BigDecimal sumHeating) {
		this.sumHeating = sumHeating;
	}
	public BigDecimal getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}
	public BigDecimal getFinalSumArea() {
		return finalSumArea;
	}
	public void setFinalSumArea(BigDecimal finalSumArea) {
		this.finalSumArea = finalSumArea;
	}
	public BigDecimal getFinalSumMaintenance() {
		return finalSumMaintenance;
	}
	public void setFinalSumMaintenance(BigDecimal finalSumMaintenance) {
		this.finalSumMaintenance = finalSumMaintenance;
	}
	public BigDecimal getFinalSumHwater() {
		return finalSumHwater;
	}
	public void setFinalSumHwater(BigDecimal finalSumHwater) {
		this.finalSumHwater = finalSumHwater;
	}
	public BigDecimal getFinalSumCwater() {
		return finalSumCwater;
	}
	public void setFinalSumCwater(BigDecimal finalSumCwater) {
		this.finalSumCwater = finalSumCwater;
	}
	public BigDecimal getFinalSumHeating() {
		return finalSumHeating;
	}
	public void setFinalSumHeating(BigDecimal finalSumHeating) {
		this.finalSumHeating = finalSumHeating;
	}
	public BigDecimal getTotalFinalSum() {
		return totalFinalSum;
	}
	public void setTotalFinalSum(BigDecimal totalFinalSum) {
		this.totalFinalSum = totalFinalSum;
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
	public BigDecimal getPreviousHwater() {
		return previousHwater;
	}
	public void setPreviousHwater(BigDecimal previousHwater) {
		this.previousHwater = previousHwater;
	}
	public BigDecimal getPreviousCwater() {
		return previousCwater;
	}
	public void setPreviousCwater(BigDecimal previousCwater) {
		this.previousCwater = previousCwater;
	}
	public BigDecimal getPreviousHeating() {
		return previousHeating;
	}
	public void setPreviousHeating(BigDecimal previousHeating) {
		this.previousHeating = previousHeating;
	}
	public BigDecimal getCurrentHwater() {
		return currentHwater;
	}
	public void setCurrentHwater(BigDecimal currentHwater) {
		this.currentHwater = currentHwater;
	}
	public BigDecimal getCurrentCwater() {
		return currentCwater;
	}
	public void setCurrentCwater(BigDecimal currentCwater) {
		this.currentCwater = currentCwater;
	}
	public BigDecimal getCurrentHeating() {
		return currentHeating;
	}
	public void setCurrentHeating(BigDecimal currentHeating) {
		this.currentHeating = currentHeating;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
 	
	
	
	
}

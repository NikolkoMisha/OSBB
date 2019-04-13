package project.dto.form;


public class ReceiptsForm {

	
	private long id;
	private long userId;
	
// Показники
	private String hWater;
	private String cWater;
	private String heating;
	private String area;
	private String homeMaintenance;
	
// Тарифи - назва	
	private String tariffsHwString;
	private String tariffsСwString;
	private String tariffsHeatingString;
	private String tariffsFlatAreaString;
	private String tariffsHomeMaintenanceString;
	
// Тарифи - ціни	
	private String tariffsHw;
	private String tariffsСw;
	private String tariffsHeating;
	private String tariffsFlatArea;
	private String tariffsHomeMaintenance;
	
// Пільга
	private String privilegesArea;
	private String privilegesHomeM;
	private String privilegesHw;
	private String privilegesCw;
	private String privilegesHeating;
	private String privilegesTotalSum;
	
// Борг
	private String areaDebt;
	private String maintenanceDebt;
	private String hWaterDebt;
	private String cWaterDebt;
	private String heatingDebt;
	private String totalSumDebt;
	
// Нараховано
	private String sumArea;
	private String sumMaintenance;
	private String sumHwater;
	private String sumCwater;
	private String sumHeating;
	private String totalSum;
	
// фінальна сума (РАЗОМ) 
	private String finalSumArea;
	private String finalSumMaintenance;
	private String finalSumHwater;
	private String finalSumCwater;
	private String finalSumHeating;
	private String totalFinalSum;
	
//  Дата за який місяць квитанція видається (те шо вгорі)
	private String month;
	private int year;
	
//  Попередні показники
	private String previousHwater;
	private String previousCwater;
	private String previousHeating;
	
//	Поточні показники
	private String currentHwater;
	private String currentCwater;
	private String currentHeating;

	
// Реквізити отримувача
	private String osbbName;
	private String eDRPOU;
	private String bankScore;
	private String bankName;
	private String bankDetails;
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
	public String gethWater() {
		return hWater;
	}
	public void sethWater(String hWater) {
		this.hWater = hWater;
	}
	public String getcWater() {
		return cWater;
	}
	public void setcWater(String cWater) {
		this.cWater = cWater;
	}
	public String getHeating() {
		return heating;
	}
	public void setHeating(String heating) {
		this.heating = heating;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHomeMaintenance() {
		return homeMaintenance;
	}
	public void setHomeMaintenance(String homeMaintenance) {
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
	public String getTariffsHw() {
		return tariffsHw;
	}
	public void setTariffsHw(String tariffsHw) {
		this.tariffsHw = tariffsHw;
	}
	public String getTariffsСw() {
		return tariffsСw;
	}
	public void setTariffsСw(String tariffsСw) {
		this.tariffsСw = tariffsСw;
	}
	public String getTariffsHeating() {
		return tariffsHeating;
	}
	public void setTariffsHeating(String tariffsHeating) {
		this.tariffsHeating = tariffsHeating;
	}
	public String getTariffsFlatArea() {
		return tariffsFlatArea;
	}
	public void setTariffsFlatArea(String tariffsFlatArea) {
		this.tariffsFlatArea = tariffsFlatArea;
	}
	public String getTariffsHomeMaintenance() {
		return tariffsHomeMaintenance;
	}
	public void setTariffsHomeMaintenance(String tariffsHomeMaintenance) {
		this.tariffsHomeMaintenance = tariffsHomeMaintenance;
	}
	public String getPrivilegesArea() {
		return privilegesArea;
	}
	public void setPrivilegesArea(String privilegesArea) {
		this.privilegesArea = privilegesArea;
	}
	public String getPrivilegesHomeM() {
		return privilegesHomeM;
	}
	public void setPrivilegesHomeM(String privilegesHomeM) {
		this.privilegesHomeM = privilegesHomeM;
	}
	public String getPrivilegesHw() {
		return privilegesHw;
	}
	public void setPrivilegesHw(String privilegesHw) {
		this.privilegesHw = privilegesHw;
	}
	public String getPrivilegesCw() {
		return privilegesCw;
	}
	public void setPrivilegesCw(String privilegesCw) {
		this.privilegesCw = privilegesCw;
	}
	public String getPrivilegesHeating() {
		return privilegesHeating;
	}
	public void setPrivilegesHeating(String privilegesHeating) {
		this.privilegesHeating = privilegesHeating;
	}
	public String getPrivilegesTotalSum() {
		return privilegesTotalSum;
	}
	public void setPrivilegesTotalSum(String privilegesTotalSum) {
		this.privilegesTotalSum = privilegesTotalSum;
	}
	public String getAreaDebt() {
		return areaDebt;
	}
	public void setAreaDebt(String areaDebt) {
		this.areaDebt = areaDebt;
	}
	public String getMaintenanceDebt() {
		return maintenanceDebt;
	}
	public void setMaintenanceDebt(String maintenanceDebt) {
		this.maintenanceDebt = maintenanceDebt;
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
	public String getTotalSumDebt() {
		return totalSumDebt;
	}
	public void setTotalSumDebt(String totalSumDebt) {
		this.totalSumDebt = totalSumDebt;
	}
	public String getSumArea() {
		return sumArea;
	}
	public void setSumArea(String sumArea) {
		this.sumArea = sumArea;
	}
	public String getSumMaintenance() {
		return sumMaintenance;
	}
	public void setSumMaintenance(String sumMaintenance) {
		this.sumMaintenance = sumMaintenance;
	}
	public String getSumHwater() {
		return sumHwater;
	}
	public void setSumHwater(String sumHwater) {
		this.sumHwater = sumHwater;
	}
	public String getSumCwater() {
		return sumCwater;
	}
	public void setSumCwater(String sumCwater) {
		this.sumCwater = sumCwater;
	}
	public String getSumHeating() {
		return sumHeating;
	}
	public void setSumHeating(String sumHeating) {
		this.sumHeating = sumHeating;
	}
	public String getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(String totalSum) {
		this.totalSum = totalSum;
	}
	public String getFinalSumArea() {
		return finalSumArea;
	}
	public void setFinalSumArea(String finalSumArea) {
		this.finalSumArea = finalSumArea;
	}
	public String getFinalSumMaintenance() {
		return finalSumMaintenance;
	}
	public void setFinalSumMaintenance(String finalSumMaintenance) {
		this.finalSumMaintenance = finalSumMaintenance;
	}
	public String getFinalSumHwater() {
		return finalSumHwater;
	}
	public void setFinalSumHwater(String finalSumHwater) {
		this.finalSumHwater = finalSumHwater;
	}
	public String getFinalSumCwater() {
		return finalSumCwater;
	}
	public void setFinalSumCwater(String finalSumCwater) {
		this.finalSumCwater = finalSumCwater;
	}
	public String getFinalSumHeating() {
		return finalSumHeating;
	}
	public void setFinalSumHeating(String finalSumHeating) {
		this.finalSumHeating = finalSumHeating;
	}
	public String getTotalFinalSum() {
		return totalFinalSum;
	}
	public void setTotalFinalSum(String totalFinalSum) {
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
	public String getPreviousHwater() {
		return previousHwater;
	}
	public void setPreviousHwater(String previousHwater) {
		this.previousHwater = previousHwater;
	}
	public String getPreviousCwater() {
		return previousCwater;
	}
	public void setPreviousCwater(String previousCwater) {
		this.previousCwater = previousCwater;
	}
	public String getPreviousHeating() {
		return previousHeating;
	}
	public void setPreviousHeating(String previousHeating) {
		this.previousHeating = previousHeating;
	}
	public String getCurrentHwater() {
		return currentHwater;
	}
	public void setCurrentHwater(String currentHwater) {
		this.currentHwater = currentHwater;
	}
	public String getCurrentCwater() {
		return currentCwater;
	}
	public void setCurrentCwater(String currentCwater) {
		this.currentCwater = currentCwater;
	}
	public String getCurrentHeating() {
		return currentHeating;
	}
	public void setCurrentHeating(String currentHeating) {
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
	
	
}

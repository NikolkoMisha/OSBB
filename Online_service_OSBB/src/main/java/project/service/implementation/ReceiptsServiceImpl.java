package project.service.implementation;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import project.dto.form.ReceiptsForm;
import project.entity.Indicators;
import project.entity.Receipts;
import project.entity.Tariffs;
import project.entity.User;
import project.entity.UserInfo;
import project.repository.OsbbInfoRepository;
import project.repository.ReceiptsRepository;
import project.repository.TariffsRepository;
import project.repository.UserInfoRepository;
import project.repository.UserRepository;
import project.service.IndicatorsService;
import project.service.ReceiptsService;
import project.validator.ReceiptsValidator;

@Service
public class ReceiptsServiceImpl implements ReceiptsService{

	@Autowired
	private ReceiptsRepository receiptsRepository;
	@Autowired
	private TariffsRepository tariffsRepository;
//	@Autowired
//	private IndicatorsRepository indicatorsRepository;
	@Autowired
	private IndicatorsService indicatorsService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;
//	@Autowired
//	private UserInfoService userInfoService;
	@Autowired
	private OsbbInfoRepository osbbInfoRepository;

	
	
	@Override
	public List<Receipts> findAll() {
		return receiptsRepository.findAll();
	}

	@Override
	public Receipts findOne(Long id) {
		return receiptsRepository.findOne(id);
	}
	
	
//	(new BigDecimal(form.replace(',' , '.')));

	@Override
	public void save(ReceiptsForm form, long id) {
	
		
		Receipts receipts = new Receipts();
		
		UserInfo userInfo = userInfoRepository.findOne(id);
		LocalDate date = LocalDate.now(ZoneId.of("Europe/Kiev"));
		ArrayList<BigDecimal> sum = new ArrayList<>();
		ArrayList<BigDecimal> totalSum = new ArrayList<>();
		List<BigDecimal> privileges = new ArrayList<>();
		List<BigDecimal> totalPrivileges = new ArrayList<>();
		List<BigDecimal> finalSum = new ArrayList<>();
		List<BigDecimal> totalFinalSum = new ArrayList<>();
		List<Tariffs> tariffs = tariffsRepository.findAll();
		List<Indicators> indicators = indicatorsService.findIndicatorsByUserId(id);
		List<Indicators> previousIndicators = indicatorsService.findPreviousIndicatorsByUserId(id);
		List<Indicators> currenIndicators = indicatorsService.findCurrentIndicatorsByUserId(id);
		List <BigDecimal> totalDebt = new ArrayList<>();
		totalDebt.add(userInfo.getFlatAreaDebt()
				.add(userInfo.gethMaintenanceDebt()).add(userInfo.gethWaterDebt())
				.add(userInfo.getcWaterDebt()).add(userInfo.getHeatingDebt()));
		privileges.add((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea())).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		privileges.add((tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance())).multiply(new BigDecimal(0)).setScale(2, BigDecimal.ROUND_HALF_UP));
		privileges.add((tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater())).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		privileges.add((tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater())).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		privileges.add((tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		totalPrivileges.add(((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea()))
				.add(tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance()))
				.add(tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater()))
					.add(tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater()))
						.add(tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating()))).multiply(userInfo.getPrivileges()).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		finalSum.add((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea())).subtract((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea())).multiply(userInfo.getPrivileges())).setScale(2, BigDecimal.ROUND_HALF_UP));
		finalSum.add((tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance())).setScale(2, BigDecimal.ROUND_HALF_UP));
		finalSum.add((tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater())).subtract((tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater())).multiply(userInfo.getPrivileges())).setScale(2, BigDecimal.ROUND_HALF_UP));
		finalSum.add((tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater())).subtract((tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater())).multiply(userInfo.getPrivileges())).setScale(2, BigDecimal.ROUND_HALF_UP));
		finalSum.add((tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).subtract((tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).multiply(userInfo.getPrivileges())).setScale(2, BigDecimal.ROUND_HALF_UP));
		totalFinalSum.add(((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea()))
				.add(tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance()))
					.add(tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater()))
						.add(tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater()))
							.add(tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())))
				.subtract(((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea()))
						.add(tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance()))
							.add(tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater()))
								.add(tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater()))
									.add(tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating()))).multiply(userInfo.getPrivileges()))
				.add(userInfo.getFlatAreaDebt().add(userInfo.gethMaintenanceDebt()).add(userInfo.gethWaterDebt()).add(userInfo.getcWaterDebt()).add(userInfo.getHeatingDebt()))
						.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		List<String> unit = new ArrayList<>();
		unit.add("куб.");
		unit.add("куб.");
		unit.add("ГКал");
		sum.add((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea())).setScale(2, BigDecimal.ROUND_HALF_UP));
		sum.add((tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance())).setScale(2, BigDecimal.ROUND_HALF_UP));
		sum.add((tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater())).setScale(2, BigDecimal.ROUND_HALF_UP));
		sum.add((tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater())).setScale(2, BigDecimal.ROUND_HALF_UP));
		sum.add((tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).setScale(2, BigDecimal.ROUND_HALF_UP));
		totalSum.add ((tariffs.get(0).getPrice().multiply(indicators.get(0).getFlatArea()))
				.add(tariffs.get(1).getPrice().multiply(indicators.get(0).getHomeMaintenance()))
				.add(tariffs.get(2).getPrice().multiply(indicators.get(0).getHwater()))
					.add(tariffs.get(3).getPrice().multiply(indicators.get(0).getCwater()))
						.add(tariffs.get(4).getPrice().multiply(indicators.get(0).getHeating())).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		
//		receipts.setId(form.getId());
		receipts.setUserId(userInfo.getId());
		receipts.setDate(date);
		
//		//***********************  Показники  ********************************//
		receipts.setArea(indicators.get(0).getFlatArea());
		receipts.setHomeMaintenance(indicators.get(0).getHomeMaintenance());
		receipts.sethWater(indicators.get(0).getHwater());
		receipts.setcWater(indicators.get(0).getCwater());
		receipts.setHeating(indicators.get(0).getHeating());
//		//***********************  Показники  ********************************//
//		
//		//***********************  Тарифи (назви)  ********************************//
		receipts.setTariffsFlatAreaString(tariffs.get(0).getName());
		receipts.setTariffsHomeMaintenanceString(tariffs.get(1).getName());
		receipts.setTariffsHwString(tariffs.get(2).getName());
		receipts.setTariffsСwString(tariffs.get(3).getName());
		receipts.setTariffsHeatingString(tariffs.get(4).getName());
//		//***********************  Тарифи (назви)  ********************************//
//		
//		//***********************  Тарифи (ціна)  ********************************//
		receipts.setTariffsFlatArea(tariffs.get(0).getPrice());
		receipts.setTariffsHomeMaintenance(tariffs.get(1).getPrice());
		receipts.setTariffsHw(tariffs.get(2).getPrice());
		receipts.setTariffsСw(tariffs.get(3).getPrice());
		receipts.setTariffsHeating(tariffs.get(4).getPrice());
//		//***********************  Тарифи (ціна)  ********************************//
//		
//		//***********************   Борг   ********************************//
		receipts.setAreaDebt(userInfo.getFlatAreaDebt());
		receipts.setMaintenanceDebt(userInfo.gethMaintenanceDebt());
		receipts.sethWaterDebt(userInfo.gethWaterDebt());
		receipts.setcWaterDebt(userInfo.getcWaterDebt());
		receipts.setHeatingDebt(userInfo.getHeatingDebt());
		receipts.setTotalSumDebt(totalDebt.get(0));
//		//***********************   Борг   ********************************//
//		
//		//***********************   Нараховано   ********************************//
		receipts.setSumArea(sum.get(0));
		receipts.setSumMaintenance(sum.get(1));
		receipts.setSumHwater(sum.get(2));
		receipts.setSumCwater(sum.get(3));
		receipts.setSumHeating(sum.get(4));
		receipts.setTotalSum(totalSum.get(0));
//		//***********************   Нараховано   ********************************//
//		
//		//***********************   Пільга   ********************************//
		receipts.setPrivilegesArea(privileges.get(0));
		receipts.setPrivilegesHomeM(privileges.get(1));
		receipts.setPrivilegesHw(privileges.get(2));
		receipts.setPrivilegesCw(privileges.get(3));
		receipts.setPrivilegesHeating(privileges.get(4));
		receipts.setPrivilegesTotalSum(totalPrivileges.get(0));
//		//***********************   Пільга   ********************************//
//		
//		//***********************   Кінцева сума   ********************************//
		
		receipts.setFinalSumArea(finalSum.get(0));
		receipts.setFinalSumMaintenance(finalSum.get(1));
		receipts.setFinalSumHwater(finalSum.get(2));
		receipts.setFinalSumCwater(finalSum.get(3));
		receipts.setFinalSumHeating(finalSum.get(4));
		receipts.setTotalFinalSum(totalFinalSum.get(0));
//		//***********************   Кінцева сума   ********************************//
//		
//		//***********************   Попередні показники   ********************************//
		receipts.setPreviousHwater(previousIndicators.get(0).getHwater());
		receipts.setPreviousCwater(previousIndicators.get(0).getCwater());
		receipts.setPreviousHeating(previousIndicators.get(0).getHeating());
//		//***********************   Попередні показники   ********************************//
//		
//		//***********************   Поточні показники   ********************************//
		receipts.setCurrentHwater(currenIndicators.get(0).getHwater());
		receipts.setCurrentCwater(currenIndicators.get(0).getCwater());
		receipts.setCurrentHeating(currenIndicators.get(0).getHeating());
//		//***********************   Поточні показники   ********************************//
		
		//***********************   ОСББ інфо   ********************************//
		receipts.setOsbbName(osbbInfoRepository.findAll().get(0).getOsbbName());
		receipts.seteDRPOU(osbbInfoRepository.findAll().get(0).geteDRPOU());
		receipts.setBankScore(osbbInfoRepository.findAll().get(0).getBankScore());
		receipts.setBankName(osbbInfoRepository.findAll().get(0).getBankName());
		receipts.setBankDetails(osbbInfoRepository.findAll().get(0).getBankDetails());
		receipts.setAddress(osbbInfoRepository.findAll().get(0).getAddress());
		//***********************   ОСББ інфо   ********************************//
		
		receipts.setMonth(form.getMonth());
		receipts.setYear(form.getYear());
		
		receipts = receiptsRepository.saveAndFlush(receipts);
		receiptsRepository.save(receipts);
	}

	@Override
	public List<Receipts> findByUserId(Principal principal ) {
//		List<Receipts> receipt = new ArrayList<>();
		User user = userRepository.findByLogin(principal.getName());
		UserInfo userInfo = userInfoRepository.findBySurname(user.getSurname());
		 receiptsRepository.findByUserId(userInfo.getId());
//			int j=0;    
//	        for(Receipts recept: receipts){
//	        	if( j<1){
//	        		receipt.add(recept);
//	        		j++;
//	        	}
//	        }
		return receiptsRepository.findByUserId(userInfo.getId());
	}
	
	
	@Override
		public Page<Receipts> findByUserId(Principal principal, Pageable pageable) {
		User user = userRepository.findByLogin(principal.getName());
		UserInfo userInfo = userInfoRepository.findBySurname(user.getSurname());
		System.out.println("---------------------------------------------------------------");
		Page<Receipts> receipts = receiptsRepository.findByUserId(userInfo.getId(), pageable);
		System.out.println("---------------------------------------------------------------");
		return receipts;
	}

	@Override
	public String findByMonth(String month) {
		return receiptsRepository.findByMonth(month);
	}

	@Override
	public Integer findByYear(int year) {
		return receiptsRepository.findByYear(year);
	}

	
	


//	@Override
//	public ReceiptsForm findForm(long id) {
//		Receipts receipts = findOne(id);
//		ReceiptsForm form = new ReceiptsForm();
//		return null;
//	}
	
	

}

package project.service.implementation;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.dto.form.IndicatorsForm;
import project.entity.Indicators;
import project.entity.User;
import project.entity.UserInfo;
import project.repository.IndicatorsRepository;
import project.repository.UserRepository;
import project.service.IndicatorsService;
import project.service.UserInfoService;

@Service
public class IndicatorsServiceImpl implements IndicatorsService {

	@Autowired
	private IndicatorsRepository indicatorsRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	public List<Indicators> findAll() {
		return indicatorsRepository.findAll();
	}

	@Override
	public void delete(long id) {
		indicatorsRepository.delete(id);
	}
	
	@Override
	public Indicators findOne(long id) {
		return indicatorsRepository.findOne(id);
	}
	
	
	@Override
	@Transactional
	public void save(IndicatorsForm form, Principal principal,String surname) {
			Indicators indicators = new Indicators();
			UserInfo userInfo = userInfoService.findBySurname(surname, principal);
			LocalDate localdate = LocalDate.now(ZoneId.of("Europe/Kiev"));
			
			indicators.setId(form.getId());
			indicators.setUserId(userInfo.getId());
			indicators.setName(userInfo.getName());
			indicators.setSurname(userInfo.getSurname());
			indicators.setApartment(userInfo.getApartment());
			indicators.setFlatArea(userInfo.getFlatArea());
			indicators.setHomeMaintenance(userInfo.getFlatArea());
			indicators.setHwater(new BigDecimal(form.getHwater().replace(',', '.')));
			indicators.setCwater(new BigDecimal(form.getCwater().replace(',', '.')));
			indicators.setHeating(new BigDecimal(form.getHeating().replace(',', '.')));
//			if((form.getHeating().replace(',', '.'))==null){
//				indicators.setHeating(new BigDecimal(0));
//			}
////			else{
////				indicators.setHeating(new BigDecimal(form.getHeating().replace(',', '.')));
////			}
			indicators.setMonth(form.getMonth());
			indicators.setYear(form.getYear());
			indicators.setDate(localdate);
			indicators = indicatorsRepository.saveAndFlush(indicators);
			indicatorsRepository.save(indicators);
	
	}
	
	@Override
	@Transactional
	public IndicatorsForm findForm(long id){
		Indicators indicators = indicatorsRepository.findOne(id);
		IndicatorsForm form = new IndicatorsForm();
		form.setId(indicators.getId());
		form.setName(indicators.getName());
		form.setSurname(indicators.getSurname());
		form.setHwater(String.valueOf(indicators.getHwater()));
		form.setCwater(String.valueOf(indicators.getCwater()));
		form.setHeating(String.valueOf(indicators.getHeating()));
		return form;
	}

	@Override
	public Indicators findByUserIndicators(String name) {
		return indicatorsRepository.findByUserIndicators(name);
	}
	
	
//	@Override
//    public Indicators findIndicatorsByUserId(long id) {
////      User user = userRepository.findByLogin(principal.getName());
//      boolean isHwater=true;
//      boolean isCwater=true;
//      boolean isHeating=true;
//      int hw=0;
//      int cw=0;
//      int he=0;
//
//      
//       Indicators indicator=new Indicators();
//    //  List <Indicators> indicator = new ArrayList<😠);
//      List <Indicators> indicators= indicatorsRepository.findIndicatorsByUserId(id);
//   //   int j=0;    
//      for(Indicators ind: indicators){
//      
//      //   if((indicators.getHwater()!=null ||indicators.getCwater()!=null || indicators.getHeating()!=null) && j<2){
//      //  indicator.add(ind);
//         //  j++;
//           
//    	  
//           if(isHwater){
//            if(hw<2){
//               if(ind.getHwater()==0 && indicator.getHwater()==0){
//                 indicator.setHwater(0.0);
//                 isHwater=false;
//              }else if(ind.getHwater()==0 && indicator.getHwater()!=0){
//                
//              }else if(ind.getHwater()!=0){
//                indicator.setHwater(ind.getHwater());
//                hw++;
//              }
//              else if(ind.getHwater()!=0 && indicator.getHwater()!=0){
//                indicator.setHwater(indicator.getHwater()-ind.getHwater());
//                isHwater=false;
//              }
//            }else if(hw>=2){
//              isHwater=false;
//            }
//           }
//           if(isCwater){
//             if(cw<2){
//               if(ind.getCwater()==0 && indicator.getCwater()==0){
//                 indicator.setCwater(0.0);
//                 isCwater=false;
//              }else if(ind.getCwater()==0 && indicator.getCwater()!=0){
//                
//              }else if(ind.getCwater()!=0){
//                indicator.setCwater(ind.getCwater());
//                cw++;
//              }
//              else if(ind.getCwater()!=0 && indicator.getCwater()!=0){
//                indicator.setCwater(indicator.getCwater()-ind.getCwater());
//                isCwater=false;
//              }
//            }else if(cw>=2){
//              isCwater=false;
//            }
//           }
//           if(isHeating){
//             if(he<2){
//               if(ind.getHeating()==0 && indicator.getHeating()==0){
//                 indicator.setHeating(0.0);
//                 isHeating=false;
//              }else if(ind.getHeating()==0 && indicator.getHeating()!=0){
//                
//              }else if(ind.getHeating()!=0){
//            	  indicator.setHeating(ind.getHeating());
//                he++;
//              }
//              else if(ind.getHeating()!=0 && indicator.getHeating()!=0){
//                indicator.setHeating(indicator.getHeating()-ind.getHeating());
//                isHeating=false;
//              }
//            }else if(he>=2){
//              isHeating=false;
//            }
//           }
//      }
//      System.out.println(indicator.getHwater());
//      System.out.println(indicator.getCwater());
//      System.out.println(indicator.getHeating());
//      return indicator;
//    }
	
		
	
	
		@Override
	    public List<Indicators> findIndicatorsByUserId(long id) {
//			boolean isHeating=true;
//			int he=0;
	        Indicators indicator=new Indicators();
	        List <Indicators> indt = new ArrayList<>();
	        List <Indicators> indicators= indicatorsRepository.findIndicatorsByUserId(id);
	        int j=0;    
	        	for(Indicators ind: indicators){
	        		if( j<2){
//	        		
//	        		if(isHeating){
//	                    if(he<2){
//	                      if(ind.getHeating()==new BigDecimal(0) && indicator.getHeating()==new BigDecimal(0)){
//	                        indicator.setHeating(new BigDecimal(0));
//	                        isHeating=false;
//	                     }else if(ind.getHeating()==new BigDecimal(0) && indicator.getHeating()!=new BigDecimal(0)){
//	                       
//	                     }else if(ind.getHeating()!=new BigDecimal(0)){
//	                   	  indicator.setHeating(ind.getHeating());
//	                       he++;
//	                     }
//	                     else if(ind.getHeating()!=new BigDecimal(0) && indicator.getHeating()!=new BigDecimal(0)){
//	                       indicator.setHeating(indicator.getHeating().subtract(ind.getHeating()));
//	                       isHeating=false;
//	                     }
//	                   }else if(he>=2){
//	                     isHeating=false;
//	                   }
//	                  }
		        		indt.add(ind);
	        			j++;
	        		}
	        	}
	      indicator.setFlatArea(indt.get(0).getFlatArea());
	      indicator.setHomeMaintenance(indt.get(0).getHomeMaintenance());
	      indicator.setHwater(indt.get(0).getHwater().subtract(indt.get(1).getHwater()));
	      indicator.setCwater(indt.get(0).getCwater().subtract(indt.get(1).getCwater()));
	      indicator.setHeating(indt.get(0).getHeating().subtract(indt.get(1).getHeating()));
	      List<Indicators> indic = new ArrayList<>();
	      	indic.add(indicator);
	      return indic;
		}

		@Override
		public List<Indicators> findCurrentIndicatorsByUserId(long id) {
			Indicators indic=new Indicators();
			List <Indicators> indt = new ArrayList<>();
			List <Indicators> indicators= indicatorsRepository.findIndicatorsByUserId(id);
				int j=0;    
			        for(Indicators ind: indicators){
			        	if( j<1){
			        		indt.add(ind);
			        		j++;
			        	}
			        }
			indic.setHwater(indt.get(0).getHwater());      
			indic.setCwater(indt.get(0).getCwater());
			indic.setHeating(indt.get(0).getHeating());
			List <Indicators> indicator = new ArrayList<>();
			indicator.add(indic);
			return indicator;
		}

		@Override
		public List<Indicators> findPreviousIndicatorsByUserId(long id) {
			Indicators indic=new Indicators();
			List <Indicators> indt = new ArrayList<>();
			List <Indicators> indicators= indicatorsRepository.findIndicatorsByUserId(id);
				int j=0;    
			        for(Indicators ind: indicators){
			        	if( j<2){
			        		indt.add(ind);
			        		j++;
			        	}
			        }
			indic.setHwater(indt.get(1).getHwater());      
			indic.setCwater(indt.get(1).getCwater());
			indic.setHeating(indt.get(1).getHeating());
			List <Indicators> indicator = new ArrayList<>();
			indicator.add(indic);
			return indicator;
		}

		@Override
		public IndicatorsForm findByMonth(String month) {
			return indicatorsRepository.findByMonth(month);
		}

		@Override
		public IndicatorsForm findByYear(int year) {
			return indicatorsRepository.findByYear(year);
		}
	
	
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
		
		<sec:authorize access="!isAuthenticated()">
			<div >
				<p style="margin-top:200px; color:red; font-size:30px; font-weight:300;font-family: 'Times New Roman', Times, serif; font-style:italic;" class="text-center">Ви неможете переглядати данний вміст.<br/>
						Увійдіть у свій акаунт для можливості перегляду.
				</p>  		
				
			 </div>
		</sec:authorize>
		
	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		 <div class="container-fluid">	
			<div class="row">
	                <div class="col-md-2 pay-menu text-center">
	                    
	                    <div class="row part-menu active-part-menu">
	                        <a href="/Receipts" class="active col-md-12">Квитанції</a>
	                    </div>
	                    <div class="row part-menu ">
	                        <a href="/Indexes" class="col-md-12">Покази</a>
	                    </div>
	         </div>
				<p style="margin-top:200px; color:red; font-size:30px;
					 font-weight:300;font-family: 'Times New Roman', Times, serif;
					  font-style:italic;" class="text-center">Адміністратор неможе мати квитанцій.<br/>
							Увійдіть у свій акаунт як мешканець для можливості перегляду.
					</p>
			</div>
		</div>
		</sec:authorize>
	</sec:authorize>
		
	<sec:authorize access="isAuthenticated()">
		<sec:authorize access="hasRole('ROLE_USER')">
		<article>
          <div class="container-fluid">
                
                <div class="row">
                <div class="col-md-2 pay-menu text-center">
                    
                    <div class="row part-menu active-part-menu">
                        <a href="/Receipts" class="active col-md-12">Квитанції</a>
                    </div>
                    <div class="row part-menu ">
                        <a href="/Indexes" class="col-md-12">Показники</a>
                    </div>
                    
                 </div>
                               
        <c:forEach items="${exception}" var="exception">
			<p style="margin-top:200px; color:red; font-size:30px; font-weight:300;font-family: 'Times New Roman', Times, serif; font-style:italic;" class="text-center">${exception}<br/>
				
				</p>
			
		</c:forEach>
		
          <c:forEach items="${page.content}" var="receipt" >          
                    <div class="col-md-10" style="margin-top:15px; ">
                    
                        <div class="row">
                            <div class="col-md-2 kvit-left-col">
                               <p>Рахунок ${receipt.month} ${receipt.year}</p>
                           
                                <p class="mar">О/Рахунок</p>
                                <p class="col-md-offset-1">${user.personalAccount}</p>
                                
                                <p class="mar">ПІБ</p>
                                <p class="col-md-offset-1">${user.surname} ${user.name} ${user.lastname}</p>
                                
                                <p class="mar">Адреса</p>
                                <p class="col-md-offset-1">${user.address}, ${user.turn}-га черга, кв.${user.apartment}</p>
                                
                                <p class="mar">Штрихкод</p>
                                <p class="col-md-offset-1"><br/><br/></p>
                                
                                <p class="mar">Отримувач</p>
                               
	                                <p class="col-md-offset-1">${receipt.osbbName}</p>
	                                <p class="col-md-offset-1">ЄДРПОУ ${receipt.eDRPOU} Р/р</p>
	                                <p class="col-md-offset-1">№${receipt.bankScore} </p>
	                                <p class="col-md-offset-1">${receipt.bankName} </p>
	                                <p class="col-md-offset-1">МФО: ${receipt.bankDetails}, адрес: ${receipt.address}</p>
                                	<br><br>
                                
                                <p class="mar">До сплати</p>
                                <p class="col-md-offset-1" style="font-size:15px; font-weight:bold">
                                	${receipt.totalFinalSum} грн.
                                </p>
                                
                                <p class="mar">Підпис платника</p>
                                <br><br>
                                <p class="col-md-offset-1 col-md-10" style="border-bottom:1px solid black"></p><br><br>
                            </div>
                            <div class="col-md-10" style="padding-left:5px;">
                                <div class="kvit-right-col">
                                
                                
                                      <p class="bord_kvit_bot text-center">РАХУНОК за <b>${receipt.month} ${receipt.year}</b></p>
                           
                           		
                                
                                    
                                    <p class="text-center bord_kvit_bot" style="font-weight:bold;">${user.surname} ${user.name} ${user.lastname} (${user.personalAccount})</p>
                                    
                                    
                                   		<p>Отримувач:${receipt.osbbName} ЄДРПОУ ${receipt.eDRPOU} Р/р №${receipt.bankScore}
												 ${receipt.bankName}, МФО: ${receipt.bankDetails},
												  адрес: ${receipt.address}</p>
												  
												  
                                    <p>Власник/наймач</p>
                                    <p>ПІБ: ${user.surname} ${user.name} ${user.lastname}</p>
                                    <p>Адреса: ${user.address} , ${user.turn}-га черга , кв.${user.apartment}</p>
                                    <p class="bord_kvit_bot">Кількість кімнат: *** Площа: ${user.flatArea} м<sup><small>2</small></sup> Кількість осіб: ${user.countTenant} </p>
                                    <br>
                                    <div class="row bord_kvit_top bord_kvit_bot" style=" border-bottom: 1px solid #003489; margin:0">
					                    <div class=" col-md-12">
					                        <div class="row" class="">
					                       		<div class="col-md-3 pad0 text-center bord_left" style="font-size:14px;">Вид платежу</div>
					                       		<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Тариф</div>
					                       		<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Норматив</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Об'єм</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Борг</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Нараховано</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Пільга</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Перерахунок</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Пеня</div>
					                        	<div class="col-md-1 pad0 text-center " style="font-size:14px;">Разом</div>
					                        </div>
						                 </div>
						            </div>
						            			<div class="row " >
                                    				<div class="col-md-12">
						                				<div class="col-md-3 pad0 bord_left">
						                					
						                						<p style="font-size:17.5px;">${receipt.tariffsFlatAreaString}</p>
						                						<p style="font-size:17.5px;">${receipt.tariffsHomeMaintenanceString}</p>
						                						<p style="font-size:17.5px;">${receipt.tariffsHwString}</p>
						                						<p style="font-size:17.5px;">${receipt.tariffsСwString}</p>
						                						<p style="font-size:17.5px;">${receipt.tariffsHeatingString}</p>
						                					
						                				</div>
						                				<div class="col-md-1 bord_left">
						                					
						                							<p style="font-size:17.5px;" >${receipt.tariffsFlatArea} </p>
						                							<p style="font-size:17.5px;" >${receipt.tariffsHomeMaintenance} </p>
						                							<p style="font-size:17.5px;" >${receipt.tariffsHw} </p>
						                							<p style="font-size:17.5px;" >${receipt.tariffsСw} </p>
						                							<p style="font-size:17.5px;" >${receipt.tariffsHeating} </p>
						                					
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					<c:forEach  begin="1" end="5">
						                						<p ><br/></p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					
						                						<p style="font-size:17.5px;">${receipt.area} </p>
						                						<p style="font-size:17.5px;">${receipt.homeMaintenance}</p>
						                						<p style="font-size:17.5px;">${receipt.hWater}</p>
						                						<p style="font-size:17.5px;">${receipt.cWater}</p>
						                						<p style="font-size:17.5px;">${receipt.heating}</p>
						                					
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                        		
						                					<p style="font-size:17.5px;"> ${receipt.areaDebt}</p>
                        									<p style="font-size:17.5px;"> ${receipt.maintenanceDebt}</p>
                        									<p style="font-size:17.5px;"> ${receipt.hWaterDebt}</p>
                         									<p style="font-size:17.5px;"> ${receipt.cWaterDebt}</p>
                         									<p style="font-size:17.5px;"> ${receipt.heatingDebt}</p>
                         									
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					
						                						<p style="font-size:17.5px;">${receipt.sumArea}</p>
						                						<p style="font-size:17.5px;">${receipt.sumMaintenance}</p>
						                						<p style="font-size:17.5px;">${receipt.sumHwater}</p>
						                						<p style="font-size:17.5px;">${receipt.sumCwater}</p>
						                						<p style="font-size:17.5px;">${receipt.sumHeating}</p>
						                					
						                				</div>
						                				<div class="col-md-1 bord_left">
						                					
						                						<p style="font-size:17.5px;">${receipt.privilegesArea}</p>
						                						<p style="font-size:17.5px;">${receipt.privilegesHomeM}</p>
						                						<p style="font-size:17.5px;">${receipt.privilegesHw}</p>
						                						<p style="font-size:17.5px;">${receipt.privilegesCw}</p>
						                						<p style="font-size:17.5px;">${receipt.privilegesHeating}</p>
						                					
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					<c:forEach  begin="1" end="5">
						                						<p ><br/></p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					<c:forEach  begin="1" end="5">
						                						<p ><br/></p>
						                					</c:forEach>
						                				</div>
						                				<div class="col-md-1 ">
						                					
						                						<p style="font-size:17.5px;">${receipt.finalSumArea}</p>
						                						<p style="font-size:17.5px;">${receipt.finalSumMaintenance}</p>
						                						<p style="font-size:17.5px;">${receipt.finalSumHwater}</p>
						                						<p style="font-size:17.5px;">${receipt.finalSumCwater}</p>
						                						<p style="font-size:17.5px;">${receipt.finalSumHeating}</p>
						                					
						                				</div>
                                    				</div>
                                    			</div>
                                    <div class="row dan_kvit bord_kvit_top" style=" margin:0">			
                                    	<div class=" col-md-12">
					                        <div class="row" class="">
					                       		<div class="col-md-6 pad0 text-left bord_left" style="font-size:14px;">До сплати:</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">
					                        		${receipt.totalSumDebt}
					                        	</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14.5px;">
					                        		${receipt.totalSum}
					                        	</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14.5px;">
					                        		${receipt.privilegesTotalSum}
					                        	</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">
					                        		
					                        	</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;"></div>
					                        	<div class="col-md-1 pad0 text-center " style="font-size:14px;">
					                        		${receipt.totalFinalSum}
					                        	</div>
					                        </div>
						                 </div>
                                   	</div>		
                                    	                                      
                                </div>
                                <div class="kvit-right-col" style="margin-top:5px;">
                                    <div class="row kvit_pokaz ">
                                   
                                        <div class="col-md-3 bord_left" >
                                            <p class="pad0" style="height:81px; line-height:81px;">Показники лічильників</p>
                                        </div>
                                        <div class="col-md-9" style="padding-left:0; padding-right: 9px;">
						                        <div class="col-md-12 bord_kvit_bot">
						                       		<div class="col-md-2 pad0 text-left bord_left" style="font-size:14px;">Вид платежу</div>
						                       		<div class="col-md-1 pad0 text-center bord_left" style="font-size:13.5px;">Одиниці</div>
						                       		<div class="col-md-2 pad0 text-center bord_left" style="font-size:14px;">Попередні</div>
						                       		<div class="col-md-2 pad0 text-center bord_left" style="font-size:14px;">Поточні</div>
						                        	<div class="col-md-2 pad0 text-center bord_left" style="font-size:14px;">Об'єм</div>
						                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">Тариф</div>
						                        	<div class="col-md-2 pad0 text-center " style="font-size:14px;">Сума</div>
						                        </div>
                                       	 </div>
                                     
                                    	 <div class="col-md-9" style="padding-left:0; padding-right: 9px;">
                                    		<div  class="col-md-12">
						                				<div class="col-md-2 pad0 bord_left">
						                					
						                						<p style="font-size:14px;">${receipt.tariffsHwString}</p>
						                						<p style="font-size:14px;">${receipt.tariffsСwString}</p>
						                						<p style="font-size:14px;">${receipt.tariffsHeatingString}</p>
						                					
						                				</div>
						                				<div class="col-md-1 bord_left">
						                			  	   	<c:forEach items="${units}" var="unit">
						                						<p class="text-center" style="font-size:12px;">${unit}</p>
						                					</c:forEach>
						                				</div>
						                				<div class="col-md-2 bord_left">
						                					
						                						<p class="text-center" style="font-size:14px;">${receipt.previousHwater}</p>
						                						<p class="text-center" style="font-size:14px;">${receipt.previousCwater}</p>
						                						<p class="text-center" style="font-size:14px;">${receipt.previousHeating}</p>
						                					
						                				</div>
						                        		<div class="col-md-2 bord_left">
						                					
						                						<p class="text-center" style="font-size:14px;">${receipt.currentHwater}</p>
						                						<p class="text-center" style="font-size:14px;">${receipt.currentCwater}</p>
						                						<p class="text-center" style="font-size:14px;">${receipt.currentHeating}</p>
						                					
						                				</div>
						                        		<div class="col-md-2 bord_left">
						                					
						                						<p class="text-center" style="font-size:14px;">${receipt.hWater}</p>
						                						<p class="text-center" style="font-size:14px;">${receipt.cWater}</p>
						                						<p class="text-center" style="font-size:14px;">${receipt.heating}</p>
						                					
						                				</div>
						                				<div class="col-md-1 bord_left text-center" style="padding: 0 7px;">
						                					
						                							<p style="font-size:12px;">${receipt.tariffsHw} </p>
						                							<p style="font-size:12px;">${receipt.tariffsСw} </p>
						                							<p style="font-size:12px;">${receipt.tariffsHeating} </p>
						                					
						                				</div>
						                        		<div class="col-md-2 ">
						                					
						                						<p class="text-center" style="font-size:14px;">${receipt.sumHwater}</p>
						                						<p class="text-center" style="font-size:14px;">${receipt.sumCwater}</p>
						                						<p class="text-center" style="font-size:14px;">${receipt.sumHeating}</p>
						                					
						                				</div>
                                    				  </div>
                                        			</div>
                                        	
                                        
                                    </div>
                                    <div class="bord_kvit_top pad0">
                                        <div class="row">
                                           <div class="col-md-10 bord_left" >
                                               <p>До сплати з урахуванням лічильників</p>
                                           </div>
                                           <div class="col-md-2 ">
                                               <p>${receipt.totalFinalSum}</p>
                                           </div>
                                        </div>
                                    </div>
                                    <div class="bord_kvit_top pad0">
                                        <div class="row">
                                           <div class="col-md-10 bord_left" >
                                               <p>Разом оплачувано за останній місяць с 30.04.2017 по 31.05.2017: </p>
                                           </div>
                                           <div class="col-md-2 ">
                                               <p>???,??</p>
                                           </div>
                                        </div>
                                    </div>
                                    <div class="bord_kvit_top pad0">
                                        <div class="row">
                                           <div class="col-md-4 bord_left" >
                                               <p>Дата останньої оплати:</p>
                                           </div>
                                           <div class="col-md-2 bord_left" >
                                               <p>31.05.2017</p>
                                           </div>
                                           <div class="col-md-4 bord_left">
                                               <p>Сума останньої оплати:</p>
                                           </div>
                                           <div class="col-md-2">
                                               <p>???,??</p>
                                           </div>
                                        </div>
                                    </div>
                                    <div class="bord_kvit_top pad0">
                                        <div class="row">
                                           <div class="col-md-4 bord_left" >
                                               <p>Дата заповнення:</p>
                                           </div>
                                           <div class="col-md-2 bord_left" >
                                               <p>31.05.2017</p>
                                           </div>
                                           <div class="col-md-6 bord_left">
                                               <p>Підпис платника:</p>
                                           </div>
                                           
                                        </div>
                                    </div>
                                </div>
                                <div class="kvit-right-col" style="margin-top:5px;">
                                    <div class="row kvit_pokaz">
                                        <div class="col-md-3 bord_left hei"></div>
                                        <div class="col-md-4 bord_left hei">
                                            <p>Телефони бухгалтерії 225-99-05</p>
                                        </div>
                                        <div class="col-md-5  hei">
                                        </div>
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                   </c:forEach>
                </div>
            </div>
            	<div class="col-sm-offset-5 col-md-4">
					<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
				</div>
        </article>
      </sec:authorize> 
    </sec:authorize> 
    	 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
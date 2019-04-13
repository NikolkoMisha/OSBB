<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<article>
            <div class="container-fluid">
            	<div class="row">
                    <div class="col-md-12 text-center uncos-title">
                        <h1>Панель адміністратора</h1>
                    </div>
                </div>
                <nav class="navbar navbar-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav menu">
                            <li class="head-menu"><a href="/admin">Адміністрування сайту</a></li>
                            <li class="head-menu"><a href="/admin/Tenants">Список мешканців</a></li>
                            <li class="active head-menu"><a href="/admin/Receipts">Квитанції</a></li>
                            <li class="head-menu"><a href="/admin/Option">Налаштування сайту</a></li>
                        </ul>
                    </div>
                </nav>
                
                <div class="row">
                	
                    <div class="col-md-2 text-center" style="margin-top:15px">
                        <div class="row">
                        	<c:forEach items="${userInfos}" var="userInfo" varStatus="status">
                            <div class="col-md-3">
                                <p>${status.count}.</p>
                            </div>
                            <div class="col-md-9  text-left" style="padding:0">
                                <a href="/admin/Receipts/${userInfo.id}">${userInfo.initials}</a>
                            </div>
                            </c:forEach>
                        </div>
                        
                    </div>
  <!--             <form:form class="form-horizontal" action="/admin/Receipts/${user.id}" method="POST" modelAttribute="receipts">
   -->           
                    <div class="col-md-10" style="margin-top:15px; ">
                    	
                        <div class="row">
                        
                            <div class="col-md-2 kvit-left-col">
                            
                                <p>Рахунок Травень 2017</p>
                                
                                <p class="mar">О/Рахунок</p>
                                <p class="col-md-offset-1">${userInfo.personalAccount}</p>
                                
                                <p class="mar">ПІБ</p>
                                <p class="col-md-offset-1">${userInfo.surname} ${userInfo.name} ${userInfo.lastname}</p>
                                
                                <p class="mar">Адреса</p>
                                <p class="col-md-offset-1">${userInfo.address}, ${userInfo.turn}-га черга, кв.${userInfo.apartment}</p>
                                
                                <p class="mar">Штрихкод</p>
                                <p class="col-md-offset-1"><br/><br/></p>
                                
                                <p class="mar">Отримувач</p>
                                <c:forEach items="${osbbInfos}" var="osbbInfo">
	                                <p class="col-md-offset-1">${osbbInfo.osbbName}</p>
	                                <p class="col-md-offset-1">ЄДРПОУ ${osbbInfo.eDRPOU} Р/р</p>
	                                <p class="col-md-offset-1">№${osbbInfo.bankScore} </p>
	                                <p class="col-md-offset-1">${osbbInfo.bankName} </p>
	                                <p class="col-md-offset-1">МФО: ${osbbInfo.bankDetails}, адрес: ${osbbInfo.address}</p>
                                	<br><br>
                                </c:forEach>
                                <p class="mar">До сплати</p>
                                <p class="col-md-offset-1" style="font-size:15px; font-weight:bold">
                                	<c:forEach items="${totalFinalSum}" var="totalFinalSum">${totalFinalSum} грн.</c:forEach>
                                </p>
                                
                                <p class="mar">Підпис платника</p>
                                <br><br>
                                <p class="col-md-offset-1 col-md-10" style="border-bottom:1px solid black"></p><br><br>
                            </div>
                            <div class="col-md-10" style="padding-left:5px;">
                                <div class="kvit-right-col">
                                    <p class="bord_kvit_bot text-center">РАХУНОК за <b>Травень 2017</b></p>
                                    <p class="text-center bord_kvit_bot" style="font-weight:bold;">${userInfo.surname} ${userInfo.name} ${userInfo.lastname} (${userInfo.personalAccount})</p>
                                    
                                    <c:forEach items="${osbbInfos}" var="osbbInfo">
                                   		<p>Отримувач:${osbbInfo.osbbName} ЄДРПОУ ${osbbInfo.eDRPOU} Р/р №${osbbInfo.bankScore}
												 ${osbbInfo.bankName}, МФО: ${osbbInfo.bankDetails},
												  адрес: ${osbbInfo.address}</p>
									</c:forEach>			  
												  
                                    <p>Власник/наймач</p>
                                    <p>ПІБ: ${userInfo.surname} ${userInfo.name} ${userInfo.lastname}</p>
                                    <p>Адреса: ${userInfo.address} , ${userInfo.turn}-га черга , кв.${userInfo.apartment}</p>
                                    <p class="bord_kvit_bot">Кількість кімнат: *** Площа: ${userInfo.flatArea} м<sup><small>2</small></sup> Кількість осіб: ${userInfo.countTenant} </p>
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
						                					<c:forEach items="${tariffses}" var="tariffs" >
						                						<p style="font-size:17.5px;">${tariffs.name}</p>
						                					</c:forEach>
						                				</div>
						                				<div class="col-md-1 bord_left">
						                					<c:forEach items="${tariffses}" var="tariffs">
						                							<p style="font-size:17.5px;" >${tariffs.price} ${unit}</p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					<c:forEach items="${tariffses}" var="tariffs">
						                						<p ><br/></p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					<c:forEach items="${indicatorses}" var="indicators">
						                						<p style="font-size:17.5px;">${indicators.flatArea}</p>
						                						<p style="font-size:17.5px;">${indicators.homeMaintenance}</p>
						                						<p style="font-size:17.5px;">${indicators.hwater}</p>
						                						<p style="font-size:17.5px;">${indicators.cwater}</p>
						                						<p style="font-size:17.5px;">${indicators.heating}</p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-1 ">
						                					<p style="font-size:17.5px;"> ${user.flatAreaDebt}</p>
                        									<p style="font-size:17.5px;"> ${user.hMaintenanceDebt}</p>
                        									<p style="font-size:17.5px;"> ${user.hWaterDebt}</p>
                         									<p style="font-size:17.5px;"> ${user.cWaterDebt}</p>
                         									<p style="font-size:17.5px;"> ${user.heatingDebt}</p>
						                				</div>
						                        		<div class="col-md-1 bord_right bord_left">
						                					<c:forEach var="sum" items="${sums}" begin="0">
						                						<p style="font-size:17.5px;">${sum}</p>
						                						
						                					</c:forEach>
						                				</div>
						                				<div class="col-md-1 bord_left">
						                					<c:forEach items="${privileges}" var="privileges">
						                						<p style="font-size:17.5px;">${privileges}</p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					<c:forEach items="${tariffses}" var="tariffs" >
						                						<p ><br/></p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					<c:forEach items="${tariffses}" var="tariffs">
						                						<p ><br/></p>
						                					</c:forEach>
						                				</div>
						                				<div class="col-md-1 ">
						                					<c:forEach items="${finalSum}" var="finalSum">
						                						<p style="font-size:17.5px;">${finalSum}</p>
						                					</c:forEach>
						                				</div>
                                    				</div>
                                    			</div>
                                    <div class="row dan_kvit bord_kvit_top" style=" margin:0">			
                                    	<div class=" col-md-12">
					                        <div class="row" class="">
					                       		<div class="col-md-6 pad0 text-left bord_left" style="font-size:14px;">До сплати:</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">
					                        		<c:forEach items="${totalDebts}" var="totalDebt">${totalDebt}</c:forEach>
					                        	</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14.5px;">
					                        		<c:forEach items="${totalSums}" var="totalSum">${totalSum}</c:forEach>
					                        	</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14.5px;">
					                        		<c:forEach items="${totalPrivileges}" var="totalPrivileges">${totalPrivileges}</c:forEach>
					                        	</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;">
					                        		
					                        	</div>
					                        	<div class="col-md-1 pad0 text-center bord_left" style="font-size:14px;"></div>
					                        	<div class="col-md-1 pad0 text-center " style="font-size:14px;">
					                        		<c:forEach items="${totalFinalSum}" var="totalFinalSum">${totalFinalSum}</c:forEach>
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
						                					<c:forEach items="${tariffses}" var="tariffs" begin="2">
						                						<p style="font-size:14px;">${tariffs.name}</p>
						                					</c:forEach>
						                				</div>
						                				<div class="col-md-1 bord_left">
						                			  	<c:forEach items="${units}" var="unit">   
						                						<p class="text-center" style="font-size:10px;">${unit}</p>
						                				</c:forEach>	
						                				</div>
						                        		<div class="col-md-2 bord_left">
						                					<c:forEach items="${indicatos}" var="indicator">
						                						<p class="text-center" style="font-size:14px;">${indicator.hwater}</p>
						                						<p class="text-center" style="font-size:14px;">${indicator.cwater}</p>
						                						<p class="text-center" style="font-size:14px;">${indicator.heating}</p>
						                					</c:forEach>
						                				</div>
						                				<div class="col-md-2 bord_left">
						                					<c:forEach items="${indicators}" var="indicator">
						                						<p class="text-center" style="font-size:14px;">${indicator.hwater}</p>
						                						<p class="text-center" style="font-size:14px;">${indicator.cwater}</p>
						                						<p class="text-center" style="font-size:14px;">${indicator.heating}</p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-2 bord_left">
						                					<c:forEach items="${indicatorses}" var="indicators">
						                						<p class="text-center" style="font-size:14px;">${indicators.hwater}</p>
						                						<p class="text-center" style="font-size:14px;">${indicators.cwater}</p>
						                						<p class="text-center" style="font-size:14px;">${indicators.heating}</p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-1 bord_left">
						                					<c:forEach items="${tariffses}" var="tariffs" begin="2">
						                						<p style="font-size:10px;">${tariffs.price}</p>
						                					</c:forEach>
						                				</div>
						                        		<div class="col-md-2 bord_left">
						                					<c:forEach var="sum" items="${sums}" begin="2">
						                						<p class="text-center" style="font-size:14px;">${sum}</p>
						                					</c:forEach>
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
                                               <p><c:forEach items="${totalFinalSum}" var="totalFinalSum">${totalFinalSum}</c:forEach></p>
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
                                        <div class="col-md-5 hei">
                                        	<form:form class="form-horizontal" action="/admin/Receipts/${userInfo.id}" method="POST" modelAttribute="receipts" enctype="multipart/form-data">
                                        		<button type="submit" class="btn btn-info">create</button>
                                        	</form:form>
                                        </div>
                                    </div> 
                                </div>
                                
                            </div>
<!--
                            <div class="col-md-9" style="padding: 0 5px;">
                                <div class="kvit-right-col">
                                    <p>РАХУНОК за <b>Травень 2017</b></p>
                                    <p class="text-center" style="font-weight:bold;">Ніколко михайло Юрійович (999999999)</p>
                                    <p>Отримувач: ОСББ "Західні ворота" АААААА 88888888 Р/с №123456789012 ЛОУ "Ощадбанк України", МФО 666666, адрес: 55555, м.Львів, вул. Городоцька, 155 А </p>
                                    <p>Власник/наймач</p>
                                    <p>ПІБ: Ніколко Михайло Юрійович</p>
                                    <p>Адреса: м. Львів, вул. Городоцька, 122А, 2-га черга, кв.155</p>
                                    <div class="col-md-11"></div>
                                    <div class="col-md-1" style="padding:0"><p>Разом</p></div>
                                    <p class="col-md-2 pad0 text-center">Вид платежу</p>
                                    <p class="col-md-1 pad0 text-center">Тариф</p>
                                    <p class="col-md-1 pad0 text-center">Норм</p>
                                    <p class="col-md-1 pad0 text-center">Об'єм</p>
                                    <p class="col-md-1 pad0 text-center">Борг</p>
                                    <p class="col-md-2 pad0 text-center">Нараховано</p>
                                    <p class="col-md-1 pad0 text-center">Пільга</p>
                                    <p class="col-md-1 pad0 text-center">Перерах</p>
                                    <p class="col-md-1 pad0 text-center">Разом</p>
                                </div>
                            </div>
-->
                        </div>
                    </div>
      <!--         </form:form>  -->
                </div>
            </div>
        </article>
        
        <label for="month" class="enter-lable" style="color:red;"><form:errors path="month"/></label>
        
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
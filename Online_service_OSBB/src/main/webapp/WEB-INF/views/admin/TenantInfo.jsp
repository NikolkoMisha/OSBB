<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	
		      
                       <div class="col-md-6">
                         <label class="col-md-6">Прізвище: ${userInfo.surname}</label>
                         <label class="col-md-6">Ім'я: ${userInfo.name}</label>
                         <label class="col-md-6">По-батькові: ${userInfo.lastname}</label>
                         <label class="col-md-6">Email: ${userInfo.email}</label>
                         <label class="col-md-6">Квартира: ${userInfo.apartment}</label>
                         <label class="col-md-6">Телефон: ${userInfo.phone}</label>
                         <label class="col-md-6">Площа квартири: ${userInfo.flatArea}</label>
                         <label class="col-md-6">Пільга: ${userInfo.privileges * 100} %</label>
                         <label class="col-md-6">Борг за квартплату: ${userInfo.flatAreaDebt} грн.</label>
                         <label class="col-md-6">Борг за утримання будинку: ${userInfo.hMaintenanceDebt} грн.</label>
                         <label class="col-md-6">Борг за гарячу воду: ${userInfo.hWaterDebt} грн.</label>
                         <label class="col-md-6">Борг за холодну воду: ${userInfo.cWaterDebt} грн.</label>
                         <label class="col-md-6">Борг за опалення: ${userInfo.heatingDebt} грн.</label>
                         <label class="col-md-6">Особовий рахунок: ${userInfo.personalAccount}</label>
                         <label class="col-md-6">Адреса: ${userInfo.address}</label>
                         <label class="col-md-6">Черга: ${userInfo.turn}</label>
                         <label class="col-md-6">Кількість прописаних осіб: ${userInfo.countTenant}</label>
                         <label class="col-md-6">Прізвище І.П. : ${userInfo.initials}</label>
                         <label class="col-md-6">Оновлено: <c:forEach items="${date}" var="date">${date}</c:forEach></label>
                     
                         
                 		<div class="col-md-3 text-center" title="Оновити"><a class="btn btn-default pay-pokazy-submit"  href="/admin/Tenants/TenantInfo/${userInfo.id}">Оновити</a></div>
                   </div> 
                     
                 
               
                <form:form  class="form-horizontal" action="/admin/Tenants/TenantInfo/${userInfo.id}" method="POST" modelAttribute="userInfo" enctype="multipart/form-data">   
                   
                   <div class="col-md-6">
							
							<form:input type="hidden" class="form-control " path="surname"  placeholder="Прізвище"/>
							
							<form:input type="hidden" class="form-control " path="name"  placeholder="Ім'я" />
							
							<form:input type="hidden" class="form-control " path="lastname"  placeholder="По-батькові"/>
							
							<form:input type="hidden" class="form-control " path="email"  placeholder="example@domain.com"/>
							
							<form:input type="hidden" class="form-control " path="phone"  placeholder="+380XXXXXXXXX"/>
						
                            <form:input type="text" class="form-control " path="initials"  placeholder="Прізвище І.П."/>
                            
                            <form:input type="text" class="form-control " path="flatArea"  placeholder="Площа квартири"/>
                            
                            <form:input type="text" class="form-control " path="privileges"  placeholder="Пільга (вводити у %)"/>
                            
                            <form:input type="text" class="form-control " path="flatAreaDebt"  placeholder="борг за квартплату"/>
                            
                            <form:input type="text" class="form-control " path="hMaintenanceDebt"  placeholder="борг за утримання будинку"/>
                            
                            <form:input type="text" class="form-control " path="hWaterDebt"  placeholder="борг за гарячу воду"/>
                            
                            <form:input type="text" class="form-control " path="cWaterDebt"  placeholder="борг за холодну воду"/>
                            
                            <form:input type="text" class="form-control " path="heatingDebt"  placeholder="борг з опалення"/>
                            
                            <form:input type="text" class="form-control " path="personalAccount"  placeholder="особовий рахунок"/>
                            
                            <form:input type="text" class="form-control " path="address"  placeholder="адреса"/>
                            
                            <form:input type="text" class="form-control " path="turn"  placeholder="черга"/>
                            
                            <form:input type="text" class="form-control " path="countTenant"  placeholder="кількість прописаних осіб"/>
                            
                            
                            
                            <button type="submit">SAVE</button>
                   </div>
               </form:form>   

		
       
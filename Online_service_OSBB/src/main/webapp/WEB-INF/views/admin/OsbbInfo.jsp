<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
                 <li class=" head-menu"><a href="/admin">Адміністрування сайту</a></li>
                 <li class="head-menu"><a href="/admin/Tenants">Список мешканців</a></li>
                 <li class="head-menu"><a href="/admin/Receipts">Квитанції</a></li>
                 <li class="head-menu active"><a href="/admin/Option">Налаштування сайту</a></li>
             </ul>
         </div>
     </nav>
     
     <div class="col-md-2 pay-menu text-center">
		<div class="row part-menu active-part-menu">
		    <a href="/admin/Option/OsbbInfo" class="col-md-12">Інформація про ОСББ</a>
		</div>
		<div class="row part-menu">
		    <a href="/admin/Option/Workers"  class="col-md-12">Працівники</a>
		</div>
		<div class="row part-menu">
             <a href="/admin/Option/Foto"  class="col-md-12">Фото(головна)</a>
         </div>
	</div>
     
	 <div class="col-md-10" style="margin-top:15px;">
	 	<div class="row">
			<div class="col-md-5 osbbinfo_inf" style="padding-left:0">
				<c:forEach items="${osbbInfos}" var="osbbInfo">  
			      <label class="col-md-12">Назва: ${osbbInfo.osbbName}</label>
			      <label class="col-md-12">ЕДРПОУ: ${osbbInfo.eDRPOU}</label>
			      <label class="col-md-12">Р/р №:${osbbInfo.bankScore}</label>
			      <label class="col-md-12">Банк отримувач: ${osbbInfo.bankName}</label>
			      <label class="col-md-12">МФО: ${osbbInfo.bankDetails}</label>
			      <label class="col-md-12">адрес: ${osbbInfo.address}</label>
			      <label class="col-md-12">Повна назва: ${osbbInfo.fName}</label>
			      <label class="col-md-12">Телефон: ${osbbInfo.phoneOSBB}</label>
			      <label class="col-md-12">Графік прийому: ${osbbInfo.workSchedule}</label>
			      <div class="col-md-2 text-center" title="Оновити"><a class=" balance-under-but btn btn-default text-center"
			       href="/admin/Option/OsbbInfo/update/${osbbInfo.id}">Оновити</a></div>
		        </c:forEach>                 
		    </div>


			<div class="col-md-7">
			<form:form class="form-horizontal" action="/admin/Option/OsbbInfo" method="POST" modelAttribute="osbbInfo" enctype="multipart/form-data">
				
				<div class="form-group">
					<label for="osbbName" class="col-sm-2 control-label" style="color:#000">Назва: </label>
		    		<div class="col-sm-3">
		      			<form:input type="text" class="form-control " path="osbbName" id="osbbName" placeholder=""/>
		      			<label for="osbbName" style="color:red;text-align:left;" class="control-label"><form:errors path="osbbName"/></label>
		    		</div>
		    		<label for="eDRPOU" class="col-sm-4 control-label" style="color:#000">ЄДРПОУ: </label>
		    		<div class="col-sm-3">
		      			<form:input type="text" class="form-control " path="eDRPOU" id="eDRPOU" placeholder=""/>
		      			<label for="eDRPOU" style="color:red;text-align:left;" class="control-label"><form:errors path="eDRPOU"/></label>
		    		</div>
		    	</div>
		    	
		    	
		    
				<div class="form-group">
					<label for="bankScore" class="col-sm-2 control-label" style="color:#000">Р/р №:</label>
		    		<div class="col-sm-3">
		      			<form:input type="text" class="form-control " path="bankScore" id="bankScore" placeholder=""/>
		      			<label for="bankScore" style="color:red;text-align:left;" class=" control-label"><form:errors path="bankScore"/></label>
		    		</div>
		    		<label for="bankName" class="col-sm-4 control-label" style="color:#000">Банк отримувач: </label>
		    		<div class="col-sm-3">
		      			<form:input type="text" class="form-control " path="bankName" id="bankName" placeholder=""/>
		      			<label for="bankName" style="color:red;text-align:left;" class="control-label"><form:errors path="bankName"/></label>
		    		</div>
		    	</div>
		    	
		    	
		    	
		    	<div class="form-group">
					<label for="bankDetails" class="col-sm-2 control-label" style="color:#000">МФО: </label>
		    		<div class="col-sm-3">
		      			<form:input type="text" class="form-control " path="bankDetails" id="bankDetails" placeholder=""/>
		      			<label for="bankDetails" style="color:red;text-align:left;" class="control-label"><form:errors path="bankDetails"/></label>
		    		</div>
		    		<label for="address" class="col-sm-4 control-label" style="color:#000">Aдрес: </label>
		    		<div class="col-sm-3">
		      			<form:input type="text" class="form-control " path="address" id="address" placeholder=""/>
		      			<label for="address" style="color:red;text-align:left;" class="control-label"><form:errors path="address"/></label>
		    		</div>
		    	</div>
		    	
		    	
		    	<div class="form-group">
		    		<label for="phoneOSBB" class="col-sm-2 control-label" style="color:#000">Телефон: </label>
		    		<div class="col-sm-3">
		      			<form:input type="text" class="form-control " path="phoneOSBB" id="phoneOSBB" placeholder=""/>
		      			<label for="phoneOSBB" style="color:red;text-align:left;" class="control-label"><form:errors path="phoneOSBB"/></label>
		    		</div>
		    		<label for="workSchedule" class="col-sm-4 control-label" style="color:#000">Графік прийому: </label>
		    		<div class="col-sm-3">
		      			<form:input type="text" class="form-control " path="workSchedule" id="workSchedule" placeholder=""/>
		      			<label for="workSchedule" style="color:red;text-align:left;" class="control-label"><form:errors path="workSchedule"/></label>
		    		</div>
		    	</div>
			    	
		    	<div class="form-group">
				  	<label for="fName" class="col-sm-2 control-label" style="color:#000">Повна назва: </label>
		    		<div class="col-sm-10">
		      			<form:input type="text" class="form-control " path="fName" id="fName" placeholder=""/>
		      			<label for="fName" style="color:red;text-align:left;" class="control-label"><form:errors path="fName"/></label>
		    		</div>
				</div>
				<div class="form-group">
						<label for="file" class="col-sm-2 control-label" style="color:#fff" >Image</label>
 					<div class="col-sm-8">
   						<input name="file" id="file" type="file" style="color:red">
 					</div>
   				</div>
				<div class="form-group">
 					<div class="col-sm-offset-2 col-sm-10">
   						<button type="submit" class="btn btn-info">Додати</button>
 					</div>
				</div>
			</form:form>
		</div>
	</div>
 </div>
</div>
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('label').hide();
	});
</script>
	
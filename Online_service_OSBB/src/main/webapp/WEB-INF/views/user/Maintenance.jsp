<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 <div class="col-md-2 pay-menu text-center">
                    <div class="row part-menu active-part-menu">
                        <a href="/Additionally/Maintenance" class="active col-md-12">Утримання будинку</a>
                    </div>
                    <div class="row part-menu ">
                        <a href="/Additionally/Balance"  class="col-md-12">Баланс ОСББ</a>
                    </div>
                    <div class="row part-menu">
                        <a href="#" class="col-md-12">Розрахунок оплати</a>
                    </div>
                    <div class="row part-menu ">
                        <a href="/Additionally/Список боржників" class="col-md-12">Список боржників</a>
                    </div>
                    <div class="row part-menu">
                        <a href="#" class="col-md-12">Подати оголошення</a>
                    </div>
                    <div class="row part-menu">
                        <a href="#" class="col-md-12">Подати пропозицію</a>
                    </div>
                    <div class="row part-menu ">
                        <a href="tariff.html" class="col-md-12">Додати новину</a>
                    </div>
                    <div class="row part-menu">
                        <a href="#" class="col-md-12">Мої дані</a>
                    </div>
                </div>
                 <div class="col-md-10">
        			<div class="uncos-title text-center">
                        <h1>Утримання будинку</h1>
                    </div>
                </div>
                <div class="col-md-10">
                <div class="row balance">
                    <div class="col-md-12 balance-button">
                    	<div class="row">
                    		<a href="/Additionally/Maintenance" class="">
                                <div class="col-md-6 balance-button11">
                                    <h3 class="text-center">Утримання будинку</h3>
                    		    </div>
                            </a>

                		    <a href="/Additionally/Tariffs">
                                <div class="col-md-6 balance-button12">
                                    <h3 class="text-center">Тарифи</h3>
                		        </div>
                            </a>

                        </div>
                    </div>
                </div>
<!--ADMIN-->
                <form:form  class="form-horizontal" action="/Additionally/Maintenance" method="POST" modelAttribute="maintenance" enctype="multipart/form-data" >
                <div class="row balance" style="margin-top:25px">
                    <div class="form-group col-md-12" style="margin:0; padding:0;">
                    	<div class="col-md-4 bal_dod text-left">
                           
                           <form:input type="text" class="form-control" path="name" placeholder="Ціль витрати"/>
  			  				<label for="name"  style="color:red; margin-top:4px;"><form:errors path="name"/></label>                    
                        </div>
                        <div class="col-md-4 bal_dod text-left">
                           
                           <form:input type="text" class="form-control " path="price" placeholder="Сума"/>
                           <label for="price"  style="color:red; margin-top:4px;"><form:errors path="price"/></label>
                        </div>
                        
	                    <div class=" col-md-4 balance-under-but text-center" style="margin-top:; border-right: none; padding-left: 0px;padding-right: 0px;">
	                        <button type="submit" class="btn btn-default" style=" width: 100%; padding-left: 0px;padding-right: 0px;">Додати</button>
	                    </div>
                    </div>
                </div>
              </form:form>
<!--END ADMIN-->
                <div class="row balance text-center" style="margin-top: ; padding-right: 0px;">
                    <div class="col-md-12">
                        <div class="row table-head">
                            <div class="col-md-1 text-center">#</div>
                            <div class="col-md-5 text-center">Ціль витрати</div>
                            <div class="col-md-4 text-center">Сума</div>
                            
                        </div>
                      <c:forEach items="${maintenances}" var="maintenance" varStatus="status">
                        <div class="row table_row">
                            <div class="col-md-1 text-center">${status.count}</div>
                            <div class="col-md-5 text-center">${maintenance.name}</div>
                            <div class="col-md-4 text-center">${maintenance.price} грн</div>
                            <div class="col-md-1 text-center"><a class="glyphicon glyphicon-pencil" href="/Additionally/Maintenance/update/${maintenance.id}"></a></div>
                           <div class="col-md-1 text-center"><a class="glyphicon glyphicon-remove" href="/Additionally/Maintenance/delete/${maintenance.id}"></a></div>
                        </div>
                      </c:forEach>
                    </div>
                </div>
  			</div>
                
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('label').hide();
	});
</script>
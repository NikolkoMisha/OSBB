<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

		<article>

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
                        <a href="" class="col-md-12">Тарифи</a>
                    </div>
                    <div class="row part-menu">
                        <a href="#" class="col-md-12">Мої дані</a>
                    </div>
                </div>
                 <div class="col-md-10">
        			<div class="uncos-title text-center">
                        <h1>Тарифи</h1>
                    </div>
                </div>
                <div class="col-md-10">
                <div class="row balance">
                    <div class="col-md-12 balance-button">
                    	<div class="row">
                    		<a href="/Additionally/Maintenance" class="">
                                <div class="col-md-6 balance-button12">
                                    <h3 class="text-center">Утримання будинку</h3>
                    		    </div>
                            </a>

                		    <a href="/Additionaly/Tariffs">
                                <div class="col-md-6 balance-button11">
                                    <h3 class="text-center">Тарифи</h3>
                		        </div>
                            </a>

                        </div>
                    </div>
                </div>
<!--ADMIN-->
			<form:form  class="form-horizontal" action="/Additionally/Tariffs" method="POST" modelAttribute="tariffs" enctype="multipart/form-data" >
                <div class="row balance" style="margin-top:25px;">
                <div class="form-group col-md-12" style="margin:0; padding:0;">
                        
                        <div class="col-md-4 bal_dod text-left">
                            <form:input type="text" class="form-control " path="name" placeholder="Ціль витрати"/>
                            <label for="name" class="enter-lable" style="color:red;"><form:errors path="name"/></label>
                        </div>
                        <div class="col-md-4 bal_dod ">
                            <form:input type="text" class="form-control " path="price" placeholder="Сума"/>
                            <label for="price" class="enter-lable" style="color:red;"><form:errors path="price"/></label>
                        </div>
	                    <div class=" col-md-4 balance-under-but text-center" style="border-right: none; padding-left: 0px;padding-right: 0px;">
	                        <button type="submit" class="btn btn-default" style="width: 100%; padding-left: 0px;padding-right: 0px;">Додати</button>
	                    </div>
                    </div>
                </div>
              </form:form>
<!--END ADMIN-->
                <div class="row balance text-center" style=" padding-right: 0px;">
                    <div class="col-md-12">
                        <div class="row table-head">
                        	<div class="col-md-1 text-center">#</div>
                            <div class="col-md-3 text-center">Назва</div>
                            <div class="col-md-offset-1 col-md-3 text-center">Тариф</div>
                            <div class="col-md-offset-1 col-md-1 text-center">Оновити</div>
                            <div class="col-md-2 text-center">Видалити</div>
                            
                        </div>
                        <c:forEach items="${tariffses}" var="tariffs" varStatus="status">
                        <div class="row table_row">
                            <div class="col-md-1 text-center">${status.count}</div>
                            <div class="col-md-3 text-center">${tariffs.name}</div>
                            <div class="col-md-offset-1 col-md-3 text-center">${tariffs.price} грн</div>
                            <div class="col-md-offset-1 col-md-1 text-center deb_but"><a class="glyphicon glyphicon-pencil" href="/Additionally/Tariffs/update/${tariffs.id}"></a></div>
							<div class="col-md-2 text-center deb_but"><a class="glyphicon glyphicon-remove" href="/Additionally/Tariffs/delete/${tariffs.id}"></a></div>
						</div>
                        </c:forEach>
                    </div>
                </div>
                </div>
        </article>
        
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('label').hide();
	});
</script>
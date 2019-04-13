<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<article>
                <div class="col-md-2 pay-menu text-center">
                    <div class="row part-menu ">
                        <a href="/Additionally/Maintenance" class="active col-md-12">Утримання будинку</a>
                    </div>
                    <div class="row part-menu active-part-menu">
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
                        <a href="" class="col-md-12">Додати новину</a>
                    </div>
                    <div class="row part-menu">
                        <a href="#" class="col-md-12">Мої дані</a>
                    </div>
                </div>
                 <div class="col-md-10">
        			<div class="uncos-title text-center">
                        <h1>Баланс ОСББ</h1>
                    </div>
                </div>
                <div class="col-md-10">
                <div class="row balance">
                    <div class="col-md-12 balance-button">
                    	<div class="row">
                    		<a href="/Additionally/Balance" class="">
                                <div class="col-md-6 balance-button11">
                                    <h3 class="text-center">Баланс ОСББ</h3>
                    		    </div>
                            </a>

                		    <a href="/Additionally/Spending">
                                <div class="col-md-6 balance-button12">
                                    <h3 class="text-center">Витрати ОСББ</h3>
                		        </div>
                            </a>

                        </div>
                    </div>
                </div>
<!--ADMIN-->
	<sec:authorize access="isAuthenticated()">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<form:form class="form-horizontal" action="/Additionally/Balance" method="POST" modelAttribute="balance" enctype="multipart/form-data">
                <div class="row balance" style="margin-top:25px;">
                	 
                	 <div class="form-group col-md-12" style="margin:0; padding:0;">
                        <div class="col-md-4 bal_dod text-right">
                            <form:input type="text" class="form-control " path="price" placeholder="Баланс"/>
                            <label for="price" class="enter-lable" style="color:red;"><form:errors path="price"/></label>
                        </div>
                        <div class="col-md-4 bal_dod ">
                            <form:input type="date" class="form-control " path="date"  />
                        </div>
                        <div class="col-md-4 bal_dod ">
                            <button type="submit" class="btn btn-default" style="width: 100%; padding-left: 0px;padding-right: 0px;">Додати</button>
                        </div>
                    </div>
                
                </div>
               </form:form>
             </sec:authorize>
        </sec:authorize>
<!--END ADMIN-->
                <div class="row balance text-center" style="padding-right: 0px;">
                    <div class="col-md-12">
                        <div class="row table-head">
                            <div class="col-md-1 text-center">#</div>
                            <div class="col-md-5 text-center">Сума</div>
                            <div class="col-md-4 text-center">Дата</div>
                            
                        </div>
                        
                   <c:forEach items="${balances}" var="balance" varStatus="status"> 
                        <div class="row table_row">
                        	<div class="col-md-1 text-center">${status.count}</div>
                            <div class="col-md-5 text-center">${balance.price} грн</div>
                            <div class="col-md-4 text-center">${balance.date}</div>
                      
                   	  <sec:authorize access="isAuthenticated()">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="col-md-1 text-center" title="Оновити"><a class="glyphicon glyphicon-pencil" href="/Additionally/Balance/update/${balance.id}"></a></div>
                           <div class="col-md-1 text-center" title="Видалити"><a class="glyphicon glyphicon-remove" href="/Additionally/Balance/delete/${balance.id}"></a></div>
                     	</sec:authorize>
                      </sec:authorize>
                        </div>
                     </c:forEach>
                       
                    </div>
                </div>
                </div>
</article>
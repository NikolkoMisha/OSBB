	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

                    <div class="row part-menu">
                        <a href="/Additionally/Balance"  class="col-md-12">Баланс ОСББ</a>
                    </div>
                    <div class="row part-menu">
                        <a href="#" class="col-md-12">Розрахунок оплати</a>
                    </div>
                    <div class="row part-menu active-part-menu">
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
                        <h1>Список боржників</h1>
                    </div>
                  
			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<form:form class="form-horizontal" action="/Additionally/Список боржників" method="POST" modelAttribute="debtor" enctype="multipart/form-data">
                   			
                   			 <div class="row deb_dod " style="margin-top:25px">
                       			 <div class="col-md-3">
                          			<form:input type="text" class="form-control " path="infoName" placeholder="Прізвище І.П."/>
                          			<label for="infoName" class="enter-lable" style="color:red;"><form:errors path="infoName"/></label>
                      			 </div>
                      			 <div class="col-md-3">
                          			<form:input type="text" class="form-control " path="apartment" placeholder="Квартира"/>
                          			<label for="apartment" class="enter-lable" style="color:red;"><form:errors path="apartment"/></label>
                      			 </div>
                      			 <div class="col-md-3">
                          			<form:input type="text" class="form-control " path="infoSum" placeholder="Сума боргу"/>
                          			<label for="infoSum" class="enter-lable" style="color:red;"><form:errors path="infoSum"/></label>
                      			 </div>
                      			 <div class="col-md-3">
                    				<button type="submit"  class=" col-md-3 balance-under-but btn btn-default text-center" style="width:100%">Додати</button>
								 </div>             				 
              				 </div>
					</form:form>
				</sec:authorize>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
                    <div class="row table-head" style="margin-left:0px; margin-top:-12px;">
                       <div class="col-md-1 text-center">#</div>
                       <div class="col-md-3 text-center">Прізвище І.П.</div>
                       <div class="col-md-3 text-center">Квартира</div>
                       <div class="col-md-3 text-center">Заборгованість</div>
                    </div>
		          
					<c:forEach items="${debtors}" var="debtor" varStatus="status">
						<div class="row table_row" style="margin-left:0px">
							<div class="col-md-1 text-center">${status.count}</div>
							<div class="col-md-3 text-center">${debtor.infoName}</div>
							<div class="col-md-3 text-center">${debtor.apartment}</div>
							<div class="col-md-3 text-center">${debtor.infoSum} грн.</div>
							<div class="col-md-1 text-center deb_but"><a class="glyphicon glyphicon-pencil" href="/Additionally/Список боржників/update/${debtor.id}"></a></div>
							<div class="col-md-1 text-center deb_but"><a class="glyphicon glyphicon-remove" href="/Additionally/Список боржників/delete/${debtor.id}"></a></div>
						</div>
					</c:forEach>
				</sec:authorize>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_USER')">
					 <div class="row table-head" style="margin-left:0px">
	                       <div class="col-md-1 text-center">#</div>
	                       <div class="col-md-4 text-center">Прізвище</div>
	                       <div class="col-md-3 text-center">Квартира</div>
	                       <div class="col-md-4 text-center">Заборгованість</div>
	                 </div>          
					<c:forEach items="${debtors}" var="debtor" varStatus="status">
						<div class="row table_row" style="margin-left:0px">
							<div class="col-md-1 text-center">${status.count}</div>
							<div class="col-md-4 text-center">${debtor.infoName}</div>
							<div class="col-md-3 text-center">${debtor.apartment}</div>
							<div class="col-md-4 text-center">${debtor.infoSum} грн.</div>
						</div>
					</c:forEach>
				</sec:authorize>
			</sec:authorize>
   
     </div>
         
   </article>
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('label').hide();
	});
</script>
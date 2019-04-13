<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

		<header>
			<nav class="navbar navbar-default">
	        	<div class="container-fluid">
		            <div class="navbar-header">
		                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		                    <span class="sr-only">Toggle navigation</span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                </button>
		                <sec:authorize access="isAuthenticated()">
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										 <a class="navbar-brand" href="/admin" style="font-weight:900; padding-left:20px; padding-right:20px">Назва ОСББ</a>
									</sec:authorize>
									<sec:authorize access="hasRole('ROLE_USER')">
										 <a class="navbar-brand" href="/" style="font-weight:900; padding-left:20px; padding-right:20px">Назва ОСББ</a>
									</sec:authorize>
				
								</sec:authorize>
		            </div>
		            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                <ul class="nav navbar-nav menu">
		                    <li class="active head-menu"><a href="/">Головна</a></li>
		                    <li class="head-menu"><a href="/Receipts">Покази та Kвитанції</a></li>
		                    <li class="head-menu"><a href="/Новини">Новини</a></li>
		                    <li class="head-menu"><a href="/Contacts">Контакти</a></li>
                            <li class="head-menu"><a href="/Additionally">Додатково</a></li>
		                    <li class="head-menu"><a href="/Chat">Форум</a></li>
                         </ul>
                         <ul class="menu nav navbar-nav navbar-right">   
			                   	<sec:authorize access="!isAuthenticated()">
									<div class="logined" class="navbar-header" style="margin-top:20px; margin-right:20px;">
										<a style="text-decoration:none;"  href="/login">Вхід</a> 
										<a style=" color:#003489"> |</a>
		  						  		<a style="text-decoration:none;"  href="/registration">Реєстрація</a>	  		
		 						 	</div>
								</sec:authorize>
								<sec:authorize access="isAuthenticated()">
									<sec:authorize access="hasRole('ROLE_ADMIN')">
									<!-- 
										<div class="admin" class="navbar-header">
									-->
							    			 <form:form action="/logout" method="POST">
							    			 	<div  style="margin-top:16px; margin-right:px;">Вітаємо, ${user.initials}
													<button  type="submit" class=" balance-under-but btn btn-default text-center" >Вихід</button>
												</div>
											 </form:form>
		   							<!--  
		   								</div>
		   							-->
									</sec:authorize>
									<sec:authorize access="hasRole('ROLE_USER')">
									<!--  	<div class="admin" class="navbar-header">
									-->
							    			<form:form action="/logout" method="POST" >
												<div style="margin-top:13px; margin-right:px;">Вітаємо вас, ${user.initials}
													<button  type="submit" class=" balance-under-but btn btn-default text-center" >Вихід</button>
												</div>
											 </form:form>
							   		<!-- 
							   			 </div>
							   		-->
									</sec:authorize>
				
								</sec:authorize>	
									
		                </ul>
		            </div>
	        	</div>
    		</nav>
		</header>
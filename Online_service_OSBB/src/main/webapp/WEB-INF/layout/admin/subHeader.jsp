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
		                <a class="navbar-brand" href="/" style="font-weight:600;">OSBB</a>
		            </div>
		            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                <ul class="nav navbar-nav menu">
		                    <li class="active head-menu"><a href="/">Головна</a></li>
		                    <li class="head-menu"><a href="/Новини">Новини</a></li>
		                    <li class="head-menu"><a href="/">Контакти</a></li>
		                    <li class="head-menu"><a href="/Additionally">Додатково</a></li>
		                    <li class="head-menu"><a href="/Chat">Форум</a></li>
		                </ul>
		                <ul class="menu nav navbar-nav navbar-right">
		    				<sec:authorize access="isAuthenticated()">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<form:form action="/logout" method="POST">
							    	 	<div style="margin-top:15px; margin-right:20px;">
											<button  type="submit" class=" balance-under-but btn btn-default text-center" >Вихід</button>
									 	</div>
									 </form:form>
		   						</sec:authorize>
							</sec:authorize>				
		                </ul>
		            </div>
	        	</div>
    		</nav>
		</header>

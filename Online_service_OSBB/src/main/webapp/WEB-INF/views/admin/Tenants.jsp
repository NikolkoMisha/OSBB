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
                            <li class="head-menu"><a href="/admin">Адміністрування сайту</a></li>
                            <li class="active head-menu"><a href="/admin/Tenatns">Список мешканців</a></li>
                            <li class="head-menu"><a href="/admin/Receipts">Квитанції</a></li>
                            <li class="head-menu"><a href="/admin/Option">Налаштування сайту</a></li>
                        </ul>
                    </div>
                </nav>
                <div class="row">
                    <div class="col-md-12 tableOccupants">
                        <div class="row table-responsive">
                        	<div class="col-md-1 text-center">#</div>
                            <div class="col-md-3 text-center">Прізвище І.</div>
                            <div class="col-md-2 text-center">Email</div>
                            <div class="col-md-2 text-center">Квартира</div>
                            <div class="col-md-2 text-center">Телефон</div>
                            <div class="col-md-2 text-center">Оновлено</div>
                        </div>
                        
                   <c:forEach items="${userInfos}" var="userInfo" varStatus="status"> 
                        <div class="row table_row">
                        	<div class="col-md-1 text-center" title="Оновити"><a class="glyphicon glyphicon-pencil" href="/admin/Tenants/TenantInfo/update/${userInfo.id}"></a></div>
                            <div class="col-md-3 text-center"><a href="/admin/Tenants/TenantInfo/${userInfo.id}">${userInfo.surname} ${userInfo.name}</a></div>
                            <div class="col-md-2 text-center">${userInfo.email}</div>
                            <div class="col-md-2 text-center">${userInfo.apartment}</div>
                            <div class="col-md-2 text-center">${userInfo.phone}</div>
                            <div class="col-md-2 text-center">${userInfo.date}</div>
                        </div>
                     </c:forEach>
                    </div>
                    </div>
               </div>
                

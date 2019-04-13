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
         <div class="row part-menu">
             <a href="/admin/Option/OsbbInfo" class="col-md-12">Інформація про ОСББ</a>
         </div>
         <div class="row part-menu">
             <a href="/admin/Option/Workers"  class="col-md-12">Працівники</a>
         </div>
         <div class="row part-menu">
             <a href="/admin/Option/Foto"  class="col-md-12">Фото(головна)</a>
         </div>
     </div>

</div>
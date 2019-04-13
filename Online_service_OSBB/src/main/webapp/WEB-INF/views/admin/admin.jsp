<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<article>
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
                            <li class="active head-menu"><a href="/admin">Адміністрування сайту</a></li>
                            <li class="head-menu"><a href="/admin/Tenants">Список мешканців</a></li>
                            <li class="head-menu"><a href="/admin/Receipts">Квитанції</a></li>
                            <li class="head-menu"><a href="/admin/Option">Налаштування сайту</a></li>
                        </ul>
                    </div>
                </nav>
                <div class="row">
                    <div class="col-md-4 pay-menu text-center">
                       
                        <div class="row part-menu">
                            <a href="/admin/NewsModeration" class="col-md-12">Модерація новин</a>
                        </div>
  <!--                       <div class="row part-menu">
                            <a href="/admin" class="col-md-12"></a>
                        </div>
                        <div class="row part-menu">
                            <a href="/admin/PropositionsModeration" class="col-md-12"></a>
                        </div>
                    
    -->
    				</div>
                    <div class="col-md-8">
                        <div class="row">
                            <div class="col-md-12">
                                <h2 class="text-center main-welcome">Ви знаходитесь на панелі адміністратора ОСББ!</h2>
                                <p style="color:red">
                                	У данному розділі ви можете:<br/>
                                	- створювати квитанції для мешканців.<br/>
                                	- проводити модерацію (новин, оголошень).<br/>
                                	- оновлювати інформацію про мешканців.<br/>
                                	- додавати працівників ОСББ.<br/>
                                	- оновлювати інформацію про ОСББ.<br/>
                                	також у Адміністратора сайту є й інші можливості, приховані на сторінках від звичайних користувачів.
                                
                                </p>
                                </div>
                        </div>
                    </div>
                    </div>
                </div>
			
		</article>
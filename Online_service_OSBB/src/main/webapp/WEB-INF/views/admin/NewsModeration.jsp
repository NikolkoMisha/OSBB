<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-fluid">
<!--                <div class="row">-->
                    <div class="col-md-12 text-center uncos-title">
                        <h1>Новини</h1>
                    </div>
<!--
                </div>
				<div class="row">
-->
					<div class="col-md-7 uncos-main">
						<form:form class="form-horizontal" action="/admin/NewsModeration" method="POST" modelAttribute="news" enctype="multipart/form-data" >
							<c:forEach items="${newses}" var="news">
							<div class="row uncos-content1 text-center">
									<div class="col-md-12">
										<h3 style="margin-top:0;">${news.theme}</h3>
										<div><img class="img-responsive" src="/images/news/${news.id}.jpg?version=${news.version}" width="40%"><p>${news.text}</p></div>	
										<div class="col-md-1 text-center" title="Оновити"><a class="glyphicon glyphicon-pencil" href="/admin/NewsModeration/update/${news.id}"></a></div>
										<div class="col-md-1 text-center" title="Видалити"><a class="glyphicon glyphicon-remove" href="/admin/NewsModeration/delete/${news.id}"></a></div>
	<!--									<div class="col-md-1 text-center" title="Опублікувати"><button style="background-color:#fff; border:0px;" class="glyphicon glyphicon-ok" type="submit"></button></div>
									<div class="uncos-border"></div>-->
										<hr style="width: 60%">
									</div>
								</div>
							</c:forEach>
						</form:form>
					</div>
					
					
					
					<div class="col-md-5 uncos-second">
					<form:form class="form-horizontal" action="/admin/NewsModeration" method="POST" modelAttribute="news" enctype="multipart/form-data" >
						<div class="text-center">
						<div class="row">
						    <div class="col-md-6" ><h2>Редагування</h2></div>
						    <div class="col-md-6"><button type="submit"><h2>Опублікувати</h2></button></div>
						</div>
				        </div>
				        
				       
							<div class="row uncos-content2">
								
									<div class="col-md-12">
										<form:input path="theme" type="text" class="form-control" placeholder="Тема"/>
										<form:textarea path="text" type="text" class="form-control" rows="17" placeholder="Текст"/>
										
									</div>
							</div>
								</form:form>
					</div>
						
						
						
						
						
					</div>
			
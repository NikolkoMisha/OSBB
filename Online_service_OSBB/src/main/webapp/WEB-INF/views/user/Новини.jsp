<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<article>
			<div class="container-fluid">
<!--                <div class="row">-->
                    <div class="col-md-12 text-center uncos-title">
                        <h1>Новини ОСББ</h1>
                    </div>
<!--
                </div>
				<div class="row">
-->
					<div class="col-md-8 uncos-main">
						<c:forEach items="${newses}" var="news">
						<div class="row uncos-content1 text-left">
								<div class="col-md-12">
									<h3 style="margin-top:0;">${news.theme}</h3>
									<div><img class="img-responsive" src="/images/news/${news.id}.jpg?version=${news.version}" width="40%"><p>${news.text}</p></div>	
									
<!--								<div class="uncos-border"></div>-->
									<hr style="width: 60%">
								</div>
							</div>
						</c:forEach>
						
					</div>
					<div class="col-md-4 uncos-second">
						<div class="text-center">
						    <h1>Новини </h1>
				        </div>
				        
				        <c:forEach items="${newses}" var="news">
							<div class="row uncos-content2">
								<div class="col-md-12">
									<img class="img-responsive" src="/images/news/${news.id}.jpg?version=${news.version}" width="250px">
									<h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</h3>
								</div>
							</div>
						</c:forEach>
						
						<hr style="width: 60%">
						
						
						
					</div>
			</div>
		</article>

<!--  <div class="row">
		
		<div class="col-md-6">
			<c:forEach items="${newses}" var="news">
				<div class="row">
					<div ><h2 >${news.theme}</h2></div>
					<div ><h5 >${news.text}</h5></div>
					<div class="col-md-1 col-xs-12">
					<img class="img-rounded" width="100%" src="/images/news/${news.id}.jpg?version=${news.version}">
					</div>
				</div>
			</c:forEach>
		</div>
</div>-->

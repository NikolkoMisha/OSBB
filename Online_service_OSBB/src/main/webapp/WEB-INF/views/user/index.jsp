	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<header>
            <div class="row slaider" >
                        <div class="col-md-12 text-center" style="padding:0px">
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                            <!-- Indicators -->
                              <ol class="carousel-indicators">
                                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel" data-slide-to="1"></li>
                                <li data-target="#myCarousel" data-slide-to="2"></li>
                                <li data-target="#myCarousel" data-slide-to="3"></li>
                              </ol>

                              <!-- Wrapper for slides -->
                              <div class="carousel-inner" role="listbox">
                                <div class="item active">
                                  <img src="http://wallspaper.ru/uploads/gallery/main/6/2e839f26-d7bf-4117-bf87-82d169654582_6.jpg">
                                  <div class="carousel-caption">
                                     <h2 style="color:red"></h2>
                                  </div>
                                </div>
                                <div class="item">
                                  <img src="https://placehold.it/1350x250">
                                  <div class="carousel-caption">
                                     <h2 style="color:red"></h2>
                                  </div>
                                </div>
                                <div class="item">
                                  <img src="https://placehold.it/1350x250">
                                  <div class="carousel-caption">
                                     <h2 style="color:red"></h2>
                                  </div>
                                </div>
                                <div class="item">
                                  <img src="https://placehold.it/1350x250">
                                  <div class="carousel-caption">
                                    <h2 style="color:red"></h2>
                                  </div>
                                </div>
                              </div>
                              <!-- Left and right controls -->
                              <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                              </a>
                              <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                              </a>
                            </div>
                        </div>
                    </div>
		</header>
<section>
		
		<article>
			<div class="container-fluid">
                <div class="col-md-3 news">
                    <div class="row news_main">
                        <div class="row">
                            <div class="col-md-6 news-title"><h4>НОВИНИ</h4></div>
                        </div>
                        <hr>
                        <c:forEach items="${newses}" var="news">
                        <div class="row">
                            <div class="col-md-2">20:42</div>
                            <div class="col-md-10">
                                <a href="" class="news-cont">${news.theme}</a>
                                <hr>
                            </div>
                        </div>
                        </c:forEach>
                        
                    </div>
         <!-- 	
                    <div class="row opros">
                        <h4>Опитування</h4>
                        <hr>
                        <h5>Чи потрібно...?</h5>
                        <p>Так</p>
                        <p >Ні</p>
                    </div>
           -->
                </div>
                <div class="col-md-9" style="padding-right: 0;">
                <div class="opros">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="text-center main-announce">Оголошення</h2>
                        </div>
                    </div>
                    <c:forEach items="${attentions}" var="attention">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="announce">${attention.theme}</h3>
                            <p>
                            	${attention.text} 
                            </p>
                        </div>
                    </div>
                    <hr style="width: 60%">
                    <div class="text-centr">
                    	<h4 class="announce text-center"><span>від</span><span>${attention.publisher}</span><span>:</span>
                    	<span >${attention.day} ${attention.month}  ${attention.year} р.</span></h4>
                    </div>
                    <hr style="width: 90%">
                    </c:forEach>
                    
                </div>
                <div class="opros">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="text-center main-announce">Пропозиції наших мешканців</h2>
                        </div>
                    </div>
                    <c:forEach var="propositions" items="${propositionses}">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="announce">${propositions.theme}<span>01.01.2001</span></h4>
                            <p>${propositions.text}</p>
                            </div>
                    </div>
                    <hr style="width: 60%">
                    </c:forEach>
                    
                </div>
            </div>    
			</div>
		</article>
	</section>
	
<script type="text/javascript">
$("#myCarousel").carousel();
</script>
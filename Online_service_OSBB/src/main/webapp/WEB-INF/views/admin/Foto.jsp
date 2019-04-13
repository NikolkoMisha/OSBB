<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- 
<header>
            <div class="row slaider" >
                        <div class="col-md-12 text-center" style="padding:0px">
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                            <!-- Indicators 
                              <ol class="carousel-indicators">
                                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel" data-slide-to="1"></li>
                                <li data-target="#myCarousel" data-slide-to="2"></li>
                                <li data-target="#myCarousel" data-slide-to="3"></li>
                              </ol>

                              <!-- Wrapper for slides 
                              <div class="carousel-inner" role="listbox">
							<c:forEach items="${foto1}" var="foto1">
                                <div class="item active">
                                  <img class="img-responsive" src="/images/osbbfoto/${foto1.key}.jpg" />
                                  <div class="carousel-caption">
                                     <h2 style="color:red">Набережний квартал</h2>
                                  </div>
                                </div>
                            </c:forEach>
                            <c:forEach items="${foto2}" var="foto2">
                                <div class="item">
                                  <img class="img-responsive" src="/images/osbbfoto/${foto2.key}.jpg" />
                                  <div class="carousel-caption">
                                     <h2 style="color:red">second launch OSBB </h2>
                                  </div>
                                </div>
                            </c:forEach>
                            <c:forEach items="${foto3}" var="foto3">
                                <div class="item">
                                  <img class="img-responsive" src="/images/osbbfoto/${foto3.key}.jpg" />
                                  <div class="carousel-caption">
                                     <h2 style="color:red">second launch OSBB </h2>
                                  </div>
                                </div>
                            </c:forEach>
                            <c:forEach items="${foto4}" var="foto4">
                                <div class="item">
                                  <img class="img-responsive" src="/images/osbbfoto/${foto4.key}.jpg" />
                                  <div class="carousel-caption">
                                     <h2 style="color:red">second launch OSBB </h2>
                                  </div>
                                </div>
                            </c:forEach>
                            
                              </div>
                              <!-- Left and right controls 
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
		</header> -->


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
			         <div class="row part-menu active-part-menu" >
			             <a href="/admin/Option/Foto"  class="col-md-12">Фото(головна)</a>
			         </div>
			     </div>
	
                <div class="row" style="margin:15px auto;">
                   <form:form class="form-horizontal" action="/admin/Option/Foto" method="POST" modelAttribute="foto" enctype="multipart/form-data">
				
					   <div class="col-md-offset-1 col-md-6">
                            <label class="col-md-3 text-right photo_label" for="photo_num"> Номер фото </label>
                            <div class="col-md-6">
                                <form:input type="text" path="nameFoto"   id="photo_num" class="form-control col-md-6 photo_input"/> 
                            </div>
                        </div>
                        <div class="col-md-10">
                            <label class="col-md-4 text-right photo_label" for="photo_photo">
                               Зображення
                            </label>
                            <div class="col-md-4" style="line-height:34px;">
                                <input name="file" id="photo_photo" type="file"> 
                            </div>
                        </div>
                        <div class="col-md-offset-1 col-md-9" style="margin-top:15px;">
                            <button type="submit" class="btn btn-default pay-pokazy-submit">Додати</button>
                        </div>
                    </form:form>
                </div>
                <hr>
              
			<c:forEach items="${fotos}" var="foto">
                <div class="row" style="margin-top:15px;">
                    <div class="col-md-offset-1 col-md-3 photo_name text-center">
                        <p>${foto.nameFoto}</p>
                    </div>
                    <div class="col-md-3 photo_preview text-center">
                        <img src="/images/osbbfoto/${foto.id}.jpg?version=${foto.version}" alt="">
                    </div>
                    <div class="col-md-4 photo_button text-center">
                         <a class="btn btn-default pay-pokazy-submit"  href="/admin/Option/Foto/delete/${foto.id}">Видалити</a> 
                    </div>
                </div>
            </c:forEach>
                <hr>
                <div class="row" style="margin:15px 0">
                    <div class="col-md-offset-1 col-md-11">
                        <p style="padding: 0 15px;"><b></b></p>
                    </div>
                </div>
         
         
         
         
         
         
         
         
         
         
         
         
             
                <div class="row slaider"  style="ma">
                        <div class="col-md-12 text-center" style="padding:0">
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                            
                              <ol class="carousel-indicators">
                                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel" data-slide-to="1"></li>
                                <li data-target="#myCarousel" data-slide-to="2"></li>
                                <li data-target="#myCarousel" data-slide-to="3"></li>
                              </ol>

                              
                              <div class="carousel-inner" role="listbox">
                                <c:forEach items="${foto1}" var="foto1">
                                <div class="item active">
                                  <img class="img-responsive" src="/images/osbbfoto/${foto1.key}.jpg" />
                                  <div class="carousel-caption">
                                     <h2 style="color:red"></h2>
                                  </div>
                                </div>
                            </c:forEach>
                            <c:forEach items="${foto2}" var="foto2">
                                <div class="item">
                                  <img class="img-responsive" src="/images/osbbfoto/${foto2.key}.jpg" />
                                  <div class="carousel-caption">
                                     <h2 style="color:red"></h2>
                                  </div>
                                </div>
                            </c:forEach>
                            <c:forEach items="${foto3}" var="foto3">
                                <div class="item">
                                  <img class="img-responsive" src="/images/osbbfoto/${foto3.key}.jpg" />
                                  <div class="carousel-caption">
                                     <h2 style="color:red"></h2>
                                  </div>
                                </div>
                            </c:forEach>
                            <c:forEach items="${foto4}" var="foto4">
                                <div class="item">
                                  <img class="img-responsive" src="/images/osbbfoto/${foto4.key}.jpg" />
                                  <div class="carousel-caption">
                                     <h2 style="color:red"></h2>
                                  </div>
                                </div>
                            </c:forEach>
                              </div>

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
            </div>
       
<!--  

			<div class="row">
	<div class="col-md-6 col-xs-12">
				<form:form class="form-horizontal" action="/admin/Option/Foto" method="POST" modelAttribute="foto" enctype="multipart/form-data">
					
					<div class="form-group">
    					<label for="theme" class="col-sm-3 control-label" style="color:#000">Номер фото</label>
    					<div class="col-sm-8">
      						<form:input type="text" class="form-control" path="nameFoto" id="nameFoto"/>
    					</div>
  					</div>
  					<div class="form-group">
  						
		  					<label for="file" class="col-sm-2 control-label" style="color:#000" >Image</label>
    					<div class="col-sm-8">
      						<input name="file" id="file" type="file" style="color:red">
    					</div>
		    			
	    			</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-info">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
	</div>
				
	
	
							
	
			<c:forEach items="${fotos}" var="foto">
				<div class="row">
						<div class="col-md-2 col-xs-12">${foto.nameFoto}</div>
						<div class="col-md-2 col-xs-12"><img class="img-responsive" src="/images/osbbfoto/${foto.id}.jpg?version=${foto.version}" width="55%"/></div>
						<div class="col-md-3 text-center" title="Видалити"><a class="btn btn-default pay-pokazy-submit"  href="/admin/Option/Foto/delete/${foto.id}">Видалити</a></div>	
					
						
				</div>
			</c:forEach>
	-->	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

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
                            <li class="head-menu"><a href="/admin">Адміністрування сайту</a></li>
                            <li class="head-menu"><a href="/admin/Tenants">Список мешканців</a></li>
                            <li class="head-menu"><a href="/admin/Receipts">Квитанції</a></li>
                            <li class="active head-menu"><a href="/admin/Option">Налаштування сайту</a></li>
                        </ul>
                    </div>
                </nav>
                
	<div class="col-md-2 pay-menu text-center">
		<div class="row part-menu ">
		    <a href="/admin/Option/OsbbInfo" class="col-md-12">Інформація про ОСББ</a>
		</div>
		<div class="row part-menu active-part-menu">
		    <a href="/admin/Option/Workers"  class="col-md-12">Працівники</a>
		</div>
		<div class="row part-menu">
             <a href="/admin/Option/Foto"  class="col-md-12">Фото(головна)</a>
         </div>
	</div>
	<div class="col-md-10" style="margin-top:15px;">
		<div class="row">
			<div class="col-md-12 col-sm-10 col-xs-12 osbb_workers">
				<form:form class="form-horizontal" action="/admin/Option/Workers" method="POST" modelAttribute="workers" enctype="multipart/form-data" >
  					<div class="form-group">
						<label for="position" class="col-sm-5 control-label" style="color:red;"><form:errors path="position"/></label>
						<label for="surname" class="col-sm-5 control-label" style="color:red;"><form:errors path="surname"/></label>
                    </div>
  					<div class="form-group">
						<label for="position" class="col-sm-2 control-label" style="color:#000">Посада</label>
    					<div class="col-sm-3">
      						<form:input type="text" class="form-control" path="position" id="position" placeholder="Посада"/>
    					</div>
    					<label for="surname" class="col-sm-2 control-label" style="color:#000">Прізвище</label>
    					<div class="col-sm-3">
      						<form:input type="text" class="form-control" path="surname" id="surname" placeholder="Прізвище"/>
    					</div>
    				</div>
    				<div class="form-group">
						<label for="name" class="col-sm-5 control-label" style="color:red;"><form:errors path="name"/></label>
						<label for="fathername" class="col-sm-5 control-label" style="color:red;"><form:errors path="fathername" /></label>
                    </div>
    				<div class="form-group">
    					<label for="name" class="col-sm-2 control-label" style="color:#000">Ім'я</label>
    					<div class="col-sm-3">
      						<form:input type="text" class="form-control" path="name" id="name" placeholder="Ім'я"/>
    					</div>
    					<label for="fathername" class="col-sm-2 control-label" style="color:#000">По-батькові</label>
    					<div class="col-sm-3">
      						<form:input type="text" class="form-control" path="fathername" id="fathername" placeholder="По-батькові"/>
    					</div>
    				</div>
    				<div class="form-group">
						<label for="phoneWorker" class="col-sm-5 control-label" style="color:red;"><form:errors path="phoneWorker"/></label>
                    </div>
    				<div class="form-group">
    					<label for="phoneWorker" class="col-sm-2 control-label" style="color:#000">Телефон</label>
    					<div class="col-sm-3">
      						<form:input type="text" class="form-control" path="phoneWorker" id="phoneWorker" placeholder="+380XXXXXXXXX"/>
    					</div>
    					<div style="padding-right:30px">
      						<button class="balance-under-but btn btn-default text-center col-md-offset-3 col-md-2">Додати</button>
    					</div>
    					
    				</div>
               </form:form> 
           </div>       
        </div>
        <hr />
   	</div>
   	
        
        
        
        <div class="col-md-offset-2 col-md-10 col-xs-12">
		  	<div class="row">
		  		<div class="col-md-2 col-xs-12"><h5 >Посада</h5></div>
		  		<div class="col-md-2 col-xs-12"><h5 >Прізвище</h5></div>
				<div class="col-md-2 col-xs-12"><h5 >Ім'я</h5></div>
				<div class="col-md-2 col-xs-12"><h5 >По-батькові</h5></div>
				<div class="col-md-2 col-xs-12"><h5 >Телефон</h5></div>
			</div>
			<c:forEach items="${workerses}" var="workers">
				<div class="row">
						<div class="col-md-2 col-xs-12"><h6 >${workers.position}</h6></div>
						<div class="col-md-2 col-xs-12"><h6 >${workers.surname}</h6></div>
						<div class="col-md-2 col-xs-12"><h6 >${workers.name}</h6></div>
						<div class="col-md-2 col-xs-12"><h6 >${workers.fathername}</h6></div>
						<div class="col-md-2 col-xs-12"><h6 >${workers.phoneWorker}</h6></div>
							
					<div class="col-md-1 col-xs-12"><a class="btn btn-success" href="/admin/Option/Workers/update/${workers.id}">Оновити</a></div>
					<div class="col-md-1 col-xs-12"><a class="btn btn-danger " href="/admin/Option/Workers/delete/${workers.id}">Видалити</a></div>
						
				</div>
				<hr />
			</c:forEach>
		</div>
	</div>
     </article> 
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>  
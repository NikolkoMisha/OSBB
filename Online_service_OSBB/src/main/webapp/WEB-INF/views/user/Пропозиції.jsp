<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-6 col-xs-12">
				<form:form class="form-horizontal" action="/Additionally/Пропозиції" method="POST" modelAttribute="propositions" enctype="multipart/form-data">
					
					<div class="form-group">
    					<label for="theme" class="col-sm-2 control-label" style="color:#fff">Заголовок</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="theme" id="theme"/>
    					</div>
    					<label for="text" class="col-sm-2 control-label" style="color:#fff">Текст</label>
    					<div class="col-sm-10">
      						<form:textarea type="text" class="form-control" path="text" id="text" rows="8"/>
    					</div>
  					</div>
  					<div class="form-group">
  						
		  					<label for="file" class="col-sm-2 control-label" style="color:#fff" >Image</label>
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
		
		<div class="col-md-6">
			<c:forEach items="${propositionses}" var="propositions">
				<div class="row">
					<div ><h2 >${propositions.theme}</h2></div>
					<div ><h5 >${propositions.text}</h5></div>
					<div class="col-md-1 col-xs-12">
					<img class="img-rounded" width="100%" src="/images/news/${propositions.id}.jpg?version=${propositions.version}">
					</div>
				</div>
			</c:forEach>
		</div>
</div>

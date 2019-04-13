<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>


	<div class="col-md-offset-2 col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-10 col-xs-12">
				<form:form class="form-horizontal" action="/покази та квитанції/показники" method="POST" modelAttribute="indicators">
					<div class="form-group">
    					<label for="Hwater" class="col-sm-4 control-label" style="color:;">Гаряча вода</label>
    					<div class="col-sm-8">
      						<form:input type="text" class="form-control" path="Hwater" id="Hwater"/>
    					</div>
    					<label for="Cwater" class="col-sm-4 control-label" style="color:;">Холодна вода</label>
    					<div class="col-sm-8">
      						<form:input type="text" class="form-control" path="Cwater" id="Cwater"/>
    					</div>
    					<label for="heating" class="col-sm-4 control-label" style="color:;">Опалення</label>
    					<div class="col-sm-8">
      						<form:input type="text" class="form-control" path="heating" id="heating"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div  class="col-sm-offset-2 col-sm-10">
      						<button  type="submit" class="btn btn-info">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		
	</div>

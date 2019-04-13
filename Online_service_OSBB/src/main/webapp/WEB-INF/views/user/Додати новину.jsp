<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-6 col-xs-12">
				<form:form class="form-horizontal" action="/Additionally/Додати новину" method="POST" modelAttribute="news" enctype="multipart/form-data">
					
					<div class="form-group">
    					<label for="theme" class="col-sm-2 control-label" style="color:#000">Заголовок</label>
    					<div class="col-md-offset-3 col-md-9 text-left">
                            <label for="theme" class="enter-lable" style="color:red;"><form:errors path="theme"/></label>
                        </div>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="theme" id="theme"/>
    					</div>
    					
    					<label for="text" class="col-sm-2 control-label" style="color:#000">Текст</label>
    					<div class="col-md-offset-3 col-md-9 text-left">
                            <label for="text" class="enter-lable" style="color:red;"><form:errors path="text"/></label>
                        </div>
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
	</div>
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>
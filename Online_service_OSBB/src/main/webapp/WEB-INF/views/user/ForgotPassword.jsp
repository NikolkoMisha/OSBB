<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<h1 style="color:red"> Введіть свій емайл </h1>
	
		<form:form class="form-horizontal" action="/ForgotPassword" method="POST" modelAttribute="user" enctype="multipart/form-data">
			<input name="email"/>
			<button type="submit" class="btn btn-success">Далі</button>
		</form:form>
	

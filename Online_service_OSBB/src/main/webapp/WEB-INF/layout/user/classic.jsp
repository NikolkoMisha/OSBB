<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,350,400,500,700,900&amp;subset=cyrillic" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/chosen.min.css">
<script src="/resources/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/style.css">

<script>
	$(function() {
		$('select').chosen();
	})
</script>
<!-- <style type="text/css">
body {
	padding-bottom: 70px; 
	padding-top: 70px;
}
@media (min-width: 1000px) {
    .navbar .navbar-nav {
        display: inline-block;
        float: none;
        vertical-align: top;
    }
    .navbar .navbar-collapse {
        text-align: center;
    }
}
@media(max-width:1000px)  {
	.nav > li{
	 	float: none;
		position: relative;
		display: block;
	}
    .navbar-collapse.collapse {
        display: none !important;
    }
    .navbar-collapse {
        overflow-x: visible !important;
    }
    .navbar-collapse.in {
      overflow-y: auto !important;
    }
    .collapse.in {
      display: block !important;
    }
    .navbar-toggle {
      display: block;
  }
}
</style>-->
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	
    <tiles:insertAttribute name="subHeader" />
	<div class="container-fluid">
		<tiles:insertAttribute name="body" />
	</div>
	<!-- 
				<tiles:insertAttribute name="footer" /> 
	 -->
</body>
</html>
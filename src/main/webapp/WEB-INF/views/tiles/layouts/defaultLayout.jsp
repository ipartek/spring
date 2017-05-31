<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<%@taglib prefix="sec"   uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form"  uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
 
 <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<![endif]-->

</head>
<body>
	<header class="container-fluid">		
		<tiles:insertAttribute name="header" />
	</header>
	<main class="container-fluid">
		<tiles:insertAttribute name="body" />
	</main>
	<footer class="container-fluid">
		<tiles:insertAttribute name="footer"/>
	</footer>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>    
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 	
	
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	<spring:message code="aplicacion.nombre" />
	<br> 
	<spring:message code="aplicacion.nombre.no.existe" text="Texto alternativo si No Existe" />  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<ol>
	<li>Ejemplo Controller pasando parametro<a href="saludo/ander">Saludo</a></li>	
	<li>Gestionar Tabla Vehiculos<a href="vehiculo">CRUD Vehiculos</a></li>
</ol>

<h2>Cambiar de Idioma</h2>
	<a href="?locale=es">				
		<spring:message code="idioma.castellano" text="castellano"/>
	</a>
	<br>
	<a href="?locale=en">
		<spring:message code="idioma.ingles" text="ingles"/>
	</a>
	<br>
	<a href="?locale=eu">
		<spring:message code="idioma.euskera" text="euskera"/>
	</a>
	<br>

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<ol>
	<li>Ejemplo Controller pasando parametro<a href="saludo/ander">Saludo</a></li>	
	<li>Gestionar Tabla Vehiculos<a href="vehiculo">CRUD Vehiculos</a></li>
</ol>

</body>
</html>

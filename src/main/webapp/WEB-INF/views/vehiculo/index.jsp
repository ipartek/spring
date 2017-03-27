<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Listado Vehiculos</h1>

<a href="vehiculo?edit">Crear Vehiculo</a>

<br><br>
<span>Total: ${total}</span>

<br><br>

<ul>
	<c:forEach items="${vehiculos}" var="v">
		<li>[${v.id}] ${v.marca} - ${v.precio}&euro; 
			<a href="#">[Modificar]</a>
			<a href="#">[Eliminar]</a>
		</li>
	</c:forEach>
</ul>

<i style="color:red;">*TODO implementar Modificar y Eliminar</i>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>formulario edicion</h1>

<form:form method="post" modelAttribute="vehiculo">

	<label for="marca">Marca:</label>
	<form:input path="marca" placeholder="Marca"/>
	<form:errors path="marca" cssClass="error"/>
	<br>
	
	
	<form:button type="submit">Crear</form:button>

</form:form>
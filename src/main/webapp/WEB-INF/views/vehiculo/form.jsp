<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h1><spring:message code="form.edit" text="Editar Formulario" /></h1>

<form:form method="post" modelAttribute="vehiculo">

	<label for="marca">Marca:</label>
	<form:input path="marca" placeholder="Marca"/>
	<form:errors path="marca" cssClass="error"/>
	<br>
	
	
	<form:button type="submit">Crear</form:button>

</form:form>
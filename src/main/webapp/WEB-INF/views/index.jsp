<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>${title}</h1>
	<h2>${message}</h2>
	<p>${path}</p>
	<p>Usuario: <b>${pageContext.request.userPrincipal.name}</b></p>
	
	
	<i>*Logeate para poder acceder a  la parte de administración</i>
	<a href="<c:url value='login' />">Ir al Login</a>

	

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h2>Excelente</h2>
		<img src="resources/img/srburns.gif"/>
	</sec:authorize>


	<sec:authorize access="hasRole('ROLE_USER') and not hasRole('ROLE_ADMIN')">
		<h2>ROSKILLAS, Ummm!!!!</h2>
		<img src="resources/img/homer-roskillas.gif"/>	
	</sec:authorize>
	
	
	<sec:authorize access="hasRole('ROLE_USER')">
		<!-- LogOut -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				<a href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
	
	</sec:authorize>
	
	
	
	
<!-- 
Podemos usar otros tipos de SpEL ( Spring Expression Language ) como:
	
	
• hasRole(rol): es cierta si el usuario actual que se ha autentificado tiene el rol
especificado

• hasAnyRole(rol1, rol2, ...): es cierta si el usuario actual que se ha autentificado
tiene uno de los rol especificados (se ponen separados por comas)

• permitAll(): es cierta por defecto, indicando por tanto que queremos permitir el
acceso a todos los usuarios. denyAll() sería lo contrario.

• isFullyAuthenticathed(): es cierta si el usuario se ha autentificado con login y
password. Esto no sería así por ejemplo en el caso en que se haya usado el
remember-me. En este caso, sería cierta la expresión isRememberMe().

• hasIpAddress(dir): cierta si el usuario se ha autentificado desde esta IP. Se pueden
usar rangos como '192.168.1.1/20'

Ejemplo:	

<sec:authorize access="hasRole('ROLE_ADMIN') and hasIpAddress('127.0.0.1')">
		<p>Esto solo lo debería ver un admin conectado localmente</p>
</sec:authorize>


 -->
	
	
</body>
</html>
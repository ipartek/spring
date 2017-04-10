# Spring 3 - SECURITY

## TAG 0.5 - Seguridad Básica

Seguridad básica y que tiene por defecto Spring con su propio login ['admin','admin'].

	- web.xml => Añadir filtro y referencia a security-context.xml
	- /WEB-INF/spring/security-context.xml
	
## TAG 0.5.1 - Seguridad Contra Base Datos

### dependencias
Spring, Spring Security, JDBC, Taglib y MySQL 

### base datos
Crear tablas necesarias para almacener "usuarios" y "roles"

###### users.sql
	CREATE  TABLE users (
	  		username VARCHAR(45) NOT NULL ,
	  		password VARCHAR(45) NOT NULL ,
	  		enabled TINYINT NOT NULL DEFAULT 1 ,
	PRIMARY KEY (username));
	
###### user_roles.sql

	CREATE TABLE user_roles (
	  user_role_id int(11) NOT NULL AUTO_INCREMENT,
	  username varchar(45) NOT NULL,
	  role varchar(45) NOT NULL,
	  PRIMARY KEY (user_role_id),
	  UNIQUE KEY uni_username_role (role,username),
	  KEY fk_username_idx (username),
	CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
	
###### juego datos pruebas
	
	INSERT INTO users(username,password,enabled)	VALUES ('administrador','123456', true);
	INSERT INTO users(username,password,enabled)	VALUES ('usuario','123456', true);
	INSERT INTO user_roles (username, role)	VALUES ('administrador', 'ROLE_USER');
	INSERT INTO user_roles (username, role) VALUES ('administrador', 'ROLE_ADMIN');
	INSERT INTO user_roles (username, role) VALUES ('usuario', 'ROLE_USER');
	
	
### spring-security.xml
Configuración de la seguridad en Spring, ver fichero en **src\main\webapp\WEB-INF\spring\security-context.xml**	
En este fichero declaramos como se va a gestionar la seguridad de nuestra app ( login, logout, pagina 403 ) y las url que vamos a interceptar para gestionar que permisos deben tener los usuarios para acceder.

Aparte del XML de configuración, tenemos que implementar un @controller **com.ipartek.com.spring.controller.SecurityController**


### seguridad en las Vitas JSP

Añadir dependencia para usar **taglibs security de Spring** 


	<dependency>
		<groupId>org.springframework.security</groupId>
		<artifactId>spring-security-taglibs</artifactId>
		<version>${org.springframework-version}</version>
	</dependency>


Hay dos formas de controlar si se muestra o no la sección de código JSP. La primera es
usar una URL como referencia, de modo que el código solo se mostrará a los usuarios que
tengan permiso para acceder a ella. Para esto se usa el atributo llamado, precisamente,
url

**<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>**

	<sec:authorize url="/admin/eliminar">
		<a href="/admin/eliminar">Eliminar</a>
	</sec:authorize>

Como se ve, esta forma de uso es muy adecuada para los casos en los que solo queremos
mostrar un enlace a los usuarios que tienen permiso para acceder a él. El resto no lo vería.
Evidentemente aunque aquí hemos puesto un enlace, en general es un fragmento
arbitrario de código JSP.
La otra forma de usar authorize es con una expresión en lenguaje SpEL (Spring
Expression Language) que mostrará el código solo si se evalúa a true. Ya vimos en la
primera sesión del módulo una muy breve introducción a este lenguaje, que nos permite
entre otras cosas evaluar expresiones aritméticas y lógicas o llamar a métodos. Hay una
serie de métodos de Spring Security específicamente diseñados para ser usados con
SpEL, por ejemplo:

	-hasRole(rol): es cierta si el usuario actual que se ha autentificado tiene el rol especificado
	-hasAnyRole(rol1, rol2, ...): es cierta si el usuario actual que se ha autentificado tiene uno de los rol especificados (se ponen separados por comas)
	-permitAll(): es cierta por defecto, indicando por tanto que queremos permitir el acceso a todos los usuarios. denyAll() sería lo contrario.
	-isFullyAuthenticathed(): es cierta si el usuario se ha autentificado con login y password. Esto no sería así por ejemplo en el caso en que se haya usado el remember-me. En este caso, sería cierta la expresión isRememberMe().
	-hasIpAddress(dir): cierta si el usuario se ha autentificado desde esta IP. Se pueden usar rangos como '192.168.1.1/20'
	
La expresión de SpEL hay que ponerla como valor del atributo access de la tag
authorize. Por ejemplo, para permitir acceso solamente a un administrador que se
conecte desde la máquina local:


	<sec:authorize access="hasRole('ROLE_ADMIN') and
		hasIpAddress('127.0.0.1')">
		<p>Esto solo lo debería ver un admin conectado localmente</p>
	</sec:authorize>
	




	
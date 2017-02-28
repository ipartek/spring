# Spring 3
![Alt text](screenshots/spring logo.png?raw=true 'logo spring')

Proyecto Web para aprender el manejo básico del FrameWork Spring 3:

	- Spring MVC
	- Spring JDBC Templates	
	- Spring Security
	- Spring AOP	 

Recomendable NO comenzar con el branch 'master', mejor comenzar con los 'TAG' creados para avanzar progresivamente con los nuevos conceptos.

## TAG 0.1
Estructura básica de Spring MVC Legacy, proyecto creado con Spring Tools Suite 3.8.3 desde Eclipse.
Añadido un controlador nuevo para típico ejemplo de Saludar pasando un parametro.

## TAG 0.2
Estructura de clases e interfaces necesaria para poder hacer una consulta en BBDD. Solo implementado 'getAll()' para recuperar un listado de Vehiculos.

## TAG 0.3
Validación de datos enviados por formulario usando JSR-303

## TAG 0.4
Internalización i18n - 3 Idiomas ( Castellano, Euskara e Ingles ).

	- Mirar carpeta src/main/resources/messages
	- Definir en root-context.xml properties de mensajes
	- Definir en servlet-context.xml interceptor para LocaleChangeInterceptor
	- Capa Presentacion ( Views ) usar TLD: taglib uri="http://www.springframework.org/tags" prefix="spring"
	- Capa Modelo POJO (domain) enlace automaticamente validaciones javax.validation api 
	

### Installation 

	. importar script para la bbdd
	. cambiar parametros conexion bbdd en src/main/resources/database.properties
	



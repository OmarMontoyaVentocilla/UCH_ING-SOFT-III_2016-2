<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESUMEN DE VENTAS</title>
</head>
<body>
	<h1>RESUMEN DE VENTAS</h1>
	<table border="1">
		<thead>
			<tr>
				<td>IDPUB</td>
				<td>TITULO</td>
				<td>VENTAS</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="r">
				<tr>
					<td>${r.idpub}</td>
					<td>${r.titulo}</td>
					<td>${r.ventas}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
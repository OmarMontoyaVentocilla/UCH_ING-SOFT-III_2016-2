<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>CONSULTAR PUBLICACIONES</h1>
	<form method="post" action="conPub.htm">
		<table>
			<tr>
				<td>Tipo</td>
				<td>Titulo</td>
				<td>Autor</td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" name="idtipo" value="${bean.idtipo}" /></td>
				<td><input type="text" name="titulo" value="${bean.titulo}" /></td>
				<td><input type="text" name="autor" value="${bean.autor}" /></td>
				<td><input type="submit" value="Consultar" /></td>
			</tr>

		</table>
	</form>
	
	<c:if test="${ not empty mensaje }">
	 <p style="color:blue;">${mensaje}</p>
	</c:if>
	
	<c:if test="${ not empty lista }">

		<h2>RESULTADO</h2>

		<table border="1">
			<thead>
				<tr>
					<td>IDPUB</td>
					<td>IDTIPO</td>
					<td>TITULO</td>
					<td>AUTOR</td>
					<td>EDI</td>
					<td>PRECIO</td>
					<td>STOCK</td>
				</tr>
			</thead>
			<tbody>
			 <c:forEach items="${lista}" var="r">
			 <tr>
			   <td>${r.idpub}</td>
			   <td>${r.idtipo}</td>
			   <td>${r.titulo}</td>
			   <td>${r.autor}</td>
			   <td>${r.edicion}</td>
			   <td>${r.precio}</td>
			   <td>${r.stock}</td>
			 </tr>
			 </c:forEach>
			</tbody>
		</table>

	</c:if>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>DEMO JDBC</h1>
	<form method="post" action="conImporte.htm">
		Id. Venta: <input type="text" name="idventa" /> <input type="submit"
			value="Procesar" />
	</form>

	<c:if test="${ not empty error }">
		<p style="color: red;">${error}</p>
	</c:if>

	<c:if test="${not empty importe }">
		<p>Importe: ${importe}</p>
	</c:if>
</body>
</html>

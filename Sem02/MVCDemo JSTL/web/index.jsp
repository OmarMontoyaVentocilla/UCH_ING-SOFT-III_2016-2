<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONSULTA PRODUCTO</title>
    </head>
    <body>
    <h>CONSULTA PRODUCTO</h1>
    <form method="post" action="ProductoTraerPorId">
        <label>Id de Producto:</label>
        <input type="text" name="id"/>
        <input type="submit" value="Consultar" />
    </form>

    <c:if test="${requestScope.error != null}">
        <p style="color:red;">${requestScope.error}</p>
    </c:if>

    <c:if test="${requestScope.model != null}">
        <h2>REPORTE</h2>
        <table>
            <tr>
                <td>ID:</td>
                <td>${requestScope.model.id}</td>
            </tr>
            <tr>
                <td>NOMBRE:</td>
                <td>${requestScope.model.nombre}</td>
            </tr>
            <tr>
                <td>PRECIO:</td>
                <td>${requestScope.model.precio}</td>
            </tr>
        </table>
    </c:if>
</body>
</html>

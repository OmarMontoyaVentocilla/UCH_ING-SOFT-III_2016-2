<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CARRITO</h1>
        <table>
            <tr>
                <th>NOMBRE</th>
                <th>PRECIO</th>
                <th>CANT</th>
                <th>SUBTOTAL</th>
            </tr>
            
            <c:forEach items="${sessionScope.carrito.lista}" var="r">
            <tr>
                <td>${r.nombre}</td>
                <td>${r.precio}</td>
                <td>${r.cant}</td>
                <td>${r.subtotal}</td>
            </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAR CLIENTES</title>
  </head>
  <body>
    <h1>CONSULTAR CLIENTES</h1>
    <form method="post" action="ClienteTraerVarios">
      <table>
        <tr>
          <td>Codigo</td>
          <td>Paterno</td>
          <td>Materno</td>
          <td>Nombre</td>
          <td></td>
        </tr>
        <tr>
          <td><input type="text" name="codigo"/></td>
          <td><input type="text" name="paterno"/></td>
          <td><input type="text" name="materno"/></td>
          <td><input type="text" name="nombre"/></td>
          <td><input type="submit" value="Consultar"/></td>
        </tr>
      </table>
    </form>

    <h1>RESULTADO</h1>
    <table BORDER="1">
      <tr>
        <td>Codigo</td>
        <td>Paterno</td>
        <td>Materno</td>
        <td>Nombre</td>
        <td>Email</td>
      </tr>

      <c:forEach items="${requestScope.lista}" var="r">
        <tr>
          <td>${r.codigo}</td>
          <td>${r.paterno}</td>
          <td>${r.materno}</td>
          <td>${r.nombre}</td>
          <td>${r.email}</td>
        </tr>
      </c:forEach>
    </table>

  </body>
</html>

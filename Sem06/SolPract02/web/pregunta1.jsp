<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PREGUNTA 1</title>
  </head>
  <body>
    <h1>PREGUNTA 1</h1>
    <form method="post" action="Pregunta1">
      Cuenta: 
      <input type="text" name="cuenta" />
      <input type="submit" value="Consultar" />
    </form>
    <c:if test="${requestScope.error != null}">
      <h2>ERROR</h2>
      <p>${requestScope.error}</p>
    </c:if>
    <c:if test="${requestScope.cuenta != null}">
      <fieldset>
        <legend>Datos de la Cuenta</legend>
        <table>
          <tr>
            <td>Cuenta:</td>
            <td>${requestScope.cuenta.cuenta}</td>
            <td>Moneda:</td>
            <td>${requestScope.cuenta.codMoneda} - ${requestScope.cuenta.moneda}</td>
          </tr>
          <tr>
            <td>Saldo:</td>
            <td>${requestScope.cuenta.saldo}</td>
            <td>Estado:</td>
            <td>${requestScope.cuenta.estado}</td>
          </tr>
          <tr>
            <td>Cliente:</td>
            <td colspan="3">
              ${requestScope.cuenta.codCliente} - 
              ${requestScope.cuenta.cliente}
            </td>
          </tr>
        </table>
      </fieldset>
    </c:if>
  </body>
</html>

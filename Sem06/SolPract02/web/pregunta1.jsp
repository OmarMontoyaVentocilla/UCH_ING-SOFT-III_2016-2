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
      <h2>RESULTADO</h2>
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

    <c:if test="${requestScope.movimientos != null}">
      <table border="1">
        <tr>
          <td>NRO.MOV.</td>
          <td>FEHCA</td>
          <td>TIPO</td>
          <td>ACCION</td>
          <td>IMPORTE</td>
        </tr>
        
        <c:forEach items="${requestScope.movimientos}" var="r">
          <tr>
            <td>${r.movinumero}</td>
            <td>${r.movifecha}</td>
            <td>${r.tiponombre}</td>
            <td>${r.tipoaccion}</td>
            <td>${r.moviimporte}</td>
          </tr>
        </c:forEach>

      </table>
    </c:if>

  </body>
</html>

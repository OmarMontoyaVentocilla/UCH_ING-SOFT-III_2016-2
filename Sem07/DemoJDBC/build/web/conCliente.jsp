<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CONSULTAR CLIENTE</title>
  </head>
  <body>
    <h1>CONSULTAR CLIENTE</h1>
    <form method="post" action="ClienteTraerUno">
      Codigo:
      <input type="text" name="codigo" value="${requestScope.codigo}"/>
      <input type="submit" value="Consultar" />
    </form>

    <c:if test="${bean != null}">
      <h1>RESULTADO</h1>
      <table>
        <tr>
          <td>CODIGO:</td>
          <td>${requestScope.bean.codigo}</td>
        </tr>
        <tr>
          <td>PATERNO:</td>
          <td>${requestScope.bean.paterno}</td>
        </tr>
      </table>
    </c:if>

    <c:if test="${requestScope.error != null}">
      <p>${requestScope.error}</p>
    </c:if>
  </body>
</html>

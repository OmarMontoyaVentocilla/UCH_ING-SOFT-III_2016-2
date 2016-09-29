<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PROCESAR RETIRO</title>
  </head>
  <body>
    <h1>PROCESAR RETIRO</h1>
    <form method="post" action="CuentaRetiro">
      Cuenta:<input type="text" name="cuenta"/><br/>
      Importe:<input type="text" name="importe"/><br/>
      Clave:<input type="text" name="clave"/><br/>
      <input type="submit" value="Procesar" />
    </form>

    <c:if test="${requestScope.error != null}">
      <p style="color: red;">${requestScope.error}</p>
    </c:if>

    <c:if test="${requestScope.mensaje != null}">
      <p style="color: blue;">${requestScope.mensaje}</p>
    </c:if>
  </body>
</html>

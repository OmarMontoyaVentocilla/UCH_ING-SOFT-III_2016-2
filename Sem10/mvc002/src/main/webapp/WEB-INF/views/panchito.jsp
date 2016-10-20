<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <h1>VENTA</h1>
  <form method="post" action="procesar.uch">
      <label>Precio:</label>
      <input type="text" name="precio" /><br/>
      <label>Cantidad:</label>
      <input type="text" name="cant" /><br/>
      <input type="submit" value="Procesar" />      
  </form>
  <c:if test="${suma != null}">
    <h2>RECULTADO</h2>
    <p>Precio: ${venta.precio}</p>
    <p>Cantidad: ${venta.cant}</p>
    <p>Importe: ${venta.importe}</p>
    <p>Impuesto: ${venta.impuesto}</p>
    <p>Total: ${venta.total}</p>
  </c:if>
</body>
</html>

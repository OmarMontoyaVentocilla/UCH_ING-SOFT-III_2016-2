<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <h1>SUMA</h1>
  <form method="post" action="procesar.uch">
      <label>Número 1:</label>
      <input type="text" name="n1" /><br/>
      <label>Número 2:</label>
      <input type="text" name="n2" /><br/>
      <input type="submit" value="Procesar" />      
  </form>
  <c:if test="${suma != null}">
    <h2>RESULTADO</h2>
    <p>Número 1: ${num1}</p>
    <p>Número 2: ${num2}</p>
    <p>Suma: ${suma}</p>
  </c:if>
</body>
</html>

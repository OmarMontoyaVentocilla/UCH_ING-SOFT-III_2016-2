<%@page import="pe.egcc.app.model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  
  <%
    if(request.getAttribute("error") != null){
     out.println("<p>" + request.getAttribute("error").toString() + "</p>");
    }
  %>
  <% if( request.getAttribute("model") != null ){ %>
  <h2>REPORTE</h2>
  <% Producto bean = (Producto) request.getAttribute("model"); %>
  <table>
    <tr>
      <td>ID:</td>
      <td><%= bean.getId() %></td>
    </tr>
    <tr>
      <td>NOMBRE:</td>
      <td><%= bean.getNombre()%></td>
    </tr>
    <tr>
      <td>PRECIO:</td>
      <td><%= bean.getPrecio()%></td>
    </tr>
  </table>
  <% } %>
  </body>
</html>

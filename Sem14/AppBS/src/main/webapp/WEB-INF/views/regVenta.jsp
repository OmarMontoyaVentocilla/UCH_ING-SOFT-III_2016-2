<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>REGISTRAR VENTA</h1>
  
  <div>${mensaje}</div>
  
  <form method="post" action="regVenta.htm">
    
      <div>
        Cliente: <input type="text" name="cliente"/>
      </div>
    
      <div>
        Publicacion: <input type="text" name="idpublicacion"/>
      </div>
      
      <div>
        Cantidad: <input type="text" name="cantidad"/>
      </div>
      
      <div>
        <input type="submit" value="Procesar" />
      </div>
  
  </form>



</body>
</html>
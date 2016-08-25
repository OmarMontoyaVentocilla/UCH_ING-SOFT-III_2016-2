<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>AGREGAR ITEM</h2>
        <form method="post" action="CarritoAgregar">
            <table>
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="nombre" /></td>
                </tr>
                <tr>
                    <td>Precio: </td>
                    <td><input type="text" name="precio" /></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cant" /></td>
                </tr>
            </table>
            <input type="submit" value="Procesar" >
        </form>
    </body>
</html>

<?php
//incluir archivo de conexion
include('conexion.php');
//asignamos a funcion de conexion a una variable
$conn = conexion();

//realizamos la consulta SQL para recuperar todos los registros de la tabla
$resultado = $conn->query("SELECT * FROM boleta");
//creamos una variable del tipo array la cual almacena todos los registros
$datos = array();
//iteramos todos los registros devueltos y llenamos el array
while ($row = $resultado->fetch_assoc()){

	$datos[] = $row;
}

//convertimos el array al formato json y mostramos para que angular JS pueda formatear la informacion
echo json_encode($datos);

?>
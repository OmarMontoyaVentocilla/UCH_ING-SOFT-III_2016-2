<?php
include('conexion.php');
$con = conexion();

function agregar($conn,$datos)
{
       if(validaUsua($conn, $datos))
       {
             echo '{"msg":"Boleta ya Existe"}';
        }
        else
       {
              $fecha=strtotime($datos->fNac);
              $fecha=date('Y-m-d',$fecha);
              $resultado = $conn->query("insert into boleta (COD_BOL ,COD_EMP, FECHA_BOL, COD_CLI, ESTADO_BOL) values  
                ('".$datos->codigo."','".$datos->codempl."','".$fecha."','".$datos->codcli."','".$estado.->estado."')");
              if(!$resultado)
             {
                      echo '{"msg":"Error al Agregar Registro Nuevo"}';
              }
              else
             {
                      echo '{"msg":"Registro Ingresado con Exito"}';
              }
        }
}
?>
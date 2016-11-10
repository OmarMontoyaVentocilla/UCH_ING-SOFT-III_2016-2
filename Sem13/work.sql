idpublicacion idpub, idtipo, titulo, autor, nroedicion edicion, precio, stock


idventa
cliente
fecha
idempleado
idpublicacion
cantidad
precio
dcto
subtotal
impuesto
total


select p.idpublicacion idpub, 
p.titulo, sum(total) ventas
from  venta v
join publicacion p 
on v.idpublicacion = p.idpublicacion
group by p.idpublicacion, p.titulo;







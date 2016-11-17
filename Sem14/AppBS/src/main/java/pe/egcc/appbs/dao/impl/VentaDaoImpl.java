package pe.egcc.appbs.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.appbs.dao.espec.VentaDaoEspec;
import pe.egcc.appbs.model.Venta;

@Repository
public class VentaDaoImpl extends AbstractDao implements VentaDaoEspec {

  @Override
  public double conImporteVenta(int idventa) {
    double importe = 0;
    try {
      String sql = "select total from venta where idventa = ?";
      Object[] args = { idventa };
      importe = jdbcTemplate.queryForObject(sql, args, Double.class);
    } catch (EmptyResultDataAccessException e) {
      throw new RuntimeException("IdVenta no existe.");
    }
    return importe;
  }

  @Override
  @Transactional(rollbackFor=Exception.class)
  public void grabar(Venta venta) {
    
    // Paso 1: Verificar stock
    String sql = "select stock from publicacion where idpublicacion=? for update";
    Object[] args = {venta.getIdpublicacion()};
    int stock = jdbcTemplate.queryForInt(sql, args);
    if(venta.getCantidad() > stock){
      throw new RuntimeException("No hay stock suficiente.");
    }
    
    // Paso 2: IdVenta
    sql = "select valor from control where parametro = 'venta' for update";
    String sidventa = jdbcTemplate.queryForObject(sql, String.class);
    int idventa = Integer.parseInt(sidventa) + 1;
    sidventa = String.valueOf(idventa);
    sql = "update control set valor = ? where parametro='venta'";
    args = new Object[]{sidventa};
    jdbcTemplate.update(sql,args);
    
    // Paso 3: Registrar Venta
    sql = "insert into venta(idventa,cliente,fecha,idempleado,"
        + "idpublicacion,cantidad,precio,dcto,subtotal,impuesto,"
        + "total) values(?,?,sysdate(),?,?,?,?,?,?,?,?)";
    args = new Object[]{idventa,venta.getCliente(),
        venta.getIdempleado(),venta.getIdpublicacion(),
        venta.getCantidad(),venta.getPrecio(),venta.getDcto(),
        venta.getSubtotal(), venta.getImpuesto(),venta.getTotal()};
    jdbcTemplate.update(sql, args);
    
    // Paso 4: Actualizar stock
    sql = "update publicacion set stock = stock - ? "
        + "where idpublicacion = ? ";
    args = new Object[]{venta.getCantidad(), venta.getIdpublicacion()};
    jdbcTemplate.update(sql, args);
    
  }

}

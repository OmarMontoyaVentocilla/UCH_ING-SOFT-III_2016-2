package pe.egcc.appbs.dao.impl;

import org.springframework.stereotype.Repository;

import pe.egcc.appbs.dao.espec.VentaDaoEspec;

@Repository
public class VentaDaoImpl 
extends AbstractDao implements VentaDaoEspec{

  @Override
  public double conImporteVenta(int idventa) {
    String sql = "select total from venta where idventa = ?";
    Object[] args = {idventa};
    double importe = jdbcTemplate
        .queryForObject(sql, args, Double.class);
    return importe;
  }

  
}

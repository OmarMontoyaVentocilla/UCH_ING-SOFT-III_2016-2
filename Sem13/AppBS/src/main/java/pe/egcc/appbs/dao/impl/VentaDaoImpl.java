package pe.egcc.appbs.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import pe.egcc.appbs.dao.espec.VentaDaoEspec;

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

}

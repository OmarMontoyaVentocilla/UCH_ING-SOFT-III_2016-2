package pe.egcc.appbs.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import pe.egcc.appbs.dao.espec.PublicacionDaoEspec;
import pe.egcc.appbs.model.Publicacion;

@Repository
public class PublicacionDaoImpl 
extends AbstractDao implements PublicacionDaoEspec{

  @Override
  public List<Publicacion> getPublicaciones(Publicacion bean) {
    String sql = "select idpublicacion idpub, idtipo, "
        + "titulo, autor, nroedicion edicion, precio, "
        + "stock from publicacion "
        + "where idtipo like concat(?,'%') "
        + "and titulo like concat('%',?,'%') "
        + "and autor like concat('%',?,'%') ";
    Object[] args = {bean.getIdtipo(), bean.getTitulo(), bean.getAutor()};
    List<Publicacion> lista = 
        jdbcTemplate.query(sql, args, 
            new BeanPropertyRowMapper<Publicacion>(Publicacion.class));
    return lista;
  }

  @Override
  public List<Map<String, Object>> getResumenVentas() {
    String sql = "select p.idpublicacion idpub, "
        + "p.titulo, sum(total) ventas "
        + "from  venta v "
        + "join publicacion p "
        + "on v.idpublicacion = p.idpublicacion "
        + "group by p.idpublicacion, p.titulo";
    List<Map<String, Object>> lista;
    lista = jdbcTemplate.queryForList(sql);
    return lista;
  }

  
  
}

package pe.egcc.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public interface RowMapper<T> {
  
  T mapRow(ResultSet rs) throws SQLException;
}

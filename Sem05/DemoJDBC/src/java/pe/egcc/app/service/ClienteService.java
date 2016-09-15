package pe.egcc.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.model.Cliente;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public class ClienteService implements RowMapper<Cliente> {

  private final String SQL_SELECT = "select chr_cliecodigo, "
          + "vch_cliepaterno, vch_cliematerno,"
          + "vch_clienombre, chr_cliedni, vch_clieciudad,"
          + "vch_cliedireccion, vch_clietelefono, "
          + "vch_clieemail from cliente ";

  public List<Cliente> getClientes(Cliente bean) {
    List<Cliente> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = SQL_SELECT
              + " where chr_cliecodigo like  concat(?,'%') "
              + " and vch_cliepaterno like  concat(?,'%') "
              + " and vch_cliematerno like concat(?,'%') "
              + " and vch_clienombre like concat(?,'%') ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getCodigo());
      pstm.setString(2, bean.getPaterno());
      pstm.setString(3, bean.getMaterno());
      pstm.setString(4, bean.getNombre());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        lista.add(mapRow(rs));
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException("No se puede realizar la consulta.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

  public Cliente getCliente(String codigo) {
    Cliente bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = SQL_SELECT + " where chr_cliecodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);;
      ResultSet rs = pstm.executeQuery();
      if (rs.next()) {
        bean = mapRow(rs);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException("No se puede realizar la consulta.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

  @Override
  public Cliente mapRow(ResultSet rs) throws SQLException {
    Cliente bean = new Cliente();
    bean.setCodigo(rs.getString("chr_cliecodigo"));
    bean.setPaterno(rs.getString("vch_cliepaterno"));
    bean.setMaterno(rs.getString("vch_cliematerno"));
    bean.setNombre(rs.getString("vch_clienombre"));
    bean.setDni(rs.getString("chr_cliedni"));
    bean.setCiudad(rs.getString("vch_clieciudad"));
    bean.setDireccion(rs.getString("vch_cliedireccion"));
    bean.setTelefono(rs.getString("vch_clietelefono"));
    bean.setEmail(rs.getString("vch_clieemail"));
    return bean;
  }

}

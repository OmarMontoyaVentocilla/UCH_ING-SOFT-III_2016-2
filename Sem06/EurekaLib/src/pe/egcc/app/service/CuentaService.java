package pe.egcc.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.egcc.app.db.AccesoDB;

public class CuentaService {

  public Map<String, Object> getCuentaPract2(String cuenta) {
    Map<String, Object> rec = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select "
              + "  c.chr_cuencodigo cuenta, "
              + "  c.dec_cuensaldo saldo, "
              + "  c.vch_cuenestado estado, "
              + "  c.chr_monecodigo codMoneda, "
              + "  m.vch_monedescripcion moneda, "
              + "  c.chr_cliecodigo codCliente, "
              + "  concat(vch_cliepaterno,' ', "
              + "	 vch_cliematerno,', ',vch_clienombre) cliente "
              + "from moneda m join cuenta c "
              + "on m.chr_monecodigo = c.chr_monecodigo "
              + "join cliente cl "
              + "on c.chr_cliecodigo = cl.chr_cliecodigo "
              + "where c.chr_cuencodigo = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if (rs.next()) {
        rec = new HashMap<>();
        rec.put("cuenta", rs.getString("cuenta"));
        rec.put("saldo", rs.getDouble("saldo"));
        rec.put("estado", rs.getString("estado"));
        rec.put("codMoneda", rs.getString("codMoneda"));
        rec.put("moneda", rs.getString("moneda"));
        rec.put("codCliente", rs.getString("codCliente"));
        rec.put("cliente", rs.getString("cliente"));
      }
      rs.close();
      pstm.close();
      if (rec == null) {
        throw new Exception("Cuenta " + cuenta + " no existe.");
      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return rec;
  }

  public List<Map<String, Object>> getMovimientosPract2(String cuenta) {
    List<Map<String, Object>> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select movinumero, movifecha, tiponombre, tipoaccion, moviimporte "
              + "from v_movimiento where cuencodigo = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Map<String,Object> rec = new HashMap<>();
        rec.put("movinumero", rs.getInt("movinumero"));
        rec.put("movifecha", rs.getDate("movifecha"));
        rec.put("tiponombre", rs.getString("tiponombre"));
        rec.put("tipoaccion", rs.getString("tipoaccion"));
        rec.put("moviimporte", rs.getDouble("moviimporte"));
        lista.add(rec);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

}

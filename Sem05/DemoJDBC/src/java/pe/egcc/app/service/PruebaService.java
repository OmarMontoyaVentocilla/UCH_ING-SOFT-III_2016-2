package pe.egcc.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import pe.egcc.app.db.AccesoDB;

public class PruebaService {

    public void regMensaje(String de, String para, String msg){
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(true);
            String sql = "insert into mensaje values('"
                    + de + "','" + para + "','" + msg + "')";
            Statement stm = cn.createStatement();
            stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch(Exception e){
            throw new RuntimeException("No se tiene acceso a la BD.");
        } finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    
    public void regMensaje2(String de, String para, String msg){
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(true);
            String sql = "insert into mensaje(de,para,msg) values(?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, de);
            pstm.setString(2, para);
            pstm.setString(3, msg);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch(Exception e){
            throw new RuntimeException("No se tiene acceso a la BD.");
        } finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    
}

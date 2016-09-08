package pe.egcc.app.prueba;

import java.sql.Connection;
import pe.egcc.app.db.AccesoDB;

public class Prueba01 {

    public static void main(String[] args) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            System.out.println("Conexion ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
    
}

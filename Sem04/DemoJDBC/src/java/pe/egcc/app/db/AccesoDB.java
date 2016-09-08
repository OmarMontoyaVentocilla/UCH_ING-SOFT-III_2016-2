package pe.egcc.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AccesoDB {

    private AccesoDB() {
    }

    public static Connection getConnection()throws SQLException{
        // Parametros de la conexion
        String driver = "com.mysql.jdbc.Driver";
        String urlDB = "jdbc:mysql://192.168.5.250:3306/EUREKABANK";
        String user = "eureka";
        String pass = "admin";
        // Variable para la conexion
        Connection cn = null;
        // Proceso
        try {
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(urlDB, user, pass);
        } catch (SQLException e) {
            throw e;
        } catch(ClassNotFoundException e){
            throw new SQLException("Error, no se encontro el driver");
        } catch(Exception e){
            throw  new SQLException("ERROR, no se puede establecer la conexion.");
        }
        return cn;
    }
    
}

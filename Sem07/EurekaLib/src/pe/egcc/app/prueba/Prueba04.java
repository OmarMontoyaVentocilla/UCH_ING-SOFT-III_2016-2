package pe.egcc.app.prueba;

import pe.egcc.app.service.CuentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public class Prueba04 {
  
  public static void main(String[] args) {
    try {
      CuentaService service = new CuentaService();
      service.registrarRetiro("00100001", 200.0, "123456", "0003");
      System.out.println("Proceso ok.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

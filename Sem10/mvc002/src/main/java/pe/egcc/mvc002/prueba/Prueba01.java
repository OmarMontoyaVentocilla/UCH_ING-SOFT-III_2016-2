package pe.egcc.mvc002.prueba;

import pe.egcc.mvc002.model.Venta;
import pe.egcc.mvc002.service.VentaService;

public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    Venta venta = new Venta();
    venta.setPrecio(2340.0);
    venta.setCant(10);
    // Proceso
    VentaService service = new VentaService();
    service.procesar(venta);
    // Reporte
    System.out.println("Importe: " + venta.getImporte());
    System.out.println("Impuesto: " + venta.getImpuesto());
    System.out.println("Total: " + venta.getTotal());
  }
}

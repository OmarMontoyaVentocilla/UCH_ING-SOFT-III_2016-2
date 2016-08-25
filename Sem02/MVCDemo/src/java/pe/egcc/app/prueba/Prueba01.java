package pe.egcc.app.prueba;

import pe.egcc.app.model.Producto;
import pe.egcc.app.service.ProductoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    ProductoService service = new ProductoService();
    Producto bean = service.obtenerProducto(1000);
    if(bean == null){
      System.err.println("No existe");
    } else {
      System.out.println(bean.toString());
    }
  }
}

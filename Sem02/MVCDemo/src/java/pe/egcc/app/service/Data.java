package pe.egcc.app.service;

import java.util.ArrayList;
import java.util.List;
import pe.egcc.app.model.Producto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public final class Data {

  private Data() {
  }

  private static final List<Producto> lista;

  static {
    lista = new ArrayList<>();
    lista.add(new Producto(100, "Producto 1", 400.0));
    lista.add(new Producto(200, "Producto 2", 600.0));
    lista.add(new Producto(300, "Producto 3", 1200.0));
    lista.add(new Producto(400, "Producto 4", 650.0));
    lista.add(new Producto(500, "Producto 5", 987.0));
    lista.add(new Producto(600, "Producto 6", 6230.0));
  }

  public static List<Producto> getLista() {
    return lista;
  }

}

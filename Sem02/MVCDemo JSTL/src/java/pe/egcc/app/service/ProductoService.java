package pe.egcc.app.service;

import pe.egcc.app.model.Producto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public class ProductoService {
  
  public Producto obtenerProducto(int id){
    Producto bean = null;
    for(Producto p: Data.getLista()){
      if(p.getId() == id){
        bean = p;
      }
    }
    return bean;
  }
}

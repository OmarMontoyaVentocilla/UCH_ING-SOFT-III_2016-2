package pe.egcc.appbs.dao.espec;

import pe.egcc.appbs.model.Venta;

public interface VentaDaoEspec {

  double conImporteVenta(int idventa);
  
  void grabar(Venta venta);
  
}

package pe.egcc.appbs.dao.espec;

import java.util.List;
import java.util.Map;

import pe.egcc.appbs.model.Publicacion;

public interface PublicacionDaoEspec {

  List<Publicacion> getPublicaciones(Publicacion bean);
  
  List<Map<String,Object>> getResumenVentas();
}

package pe.egcc.appbs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.appbs.dao.espec.PublicacionDaoEspec;
import pe.egcc.appbs.model.Publicacion;

@Service
public class PublicacionService {

  @Autowired
  private PublicacionDaoEspec publicacionDao;
  
  public List<Publicacion> getPublicaciones(Publicacion bean) {
    return publicacionDao.getPublicaciones(bean);
  }
  
  public List<Map<String, Object>> getResumenVentas() {
    return publicacionDao.getResumenVentas();
  }
  
}

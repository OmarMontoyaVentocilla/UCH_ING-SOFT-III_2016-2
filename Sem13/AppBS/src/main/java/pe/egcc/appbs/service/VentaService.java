package pe.egcc.appbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.appbs.dao.espec.VentaDaoEspec;

@Service
public class VentaService {

  @Autowired
  private VentaDaoEspec ventaDao;
  
  public double conImporteVenta(int idventa){
    return ventaDao.conImporteVenta(idventa);
  }
  
}

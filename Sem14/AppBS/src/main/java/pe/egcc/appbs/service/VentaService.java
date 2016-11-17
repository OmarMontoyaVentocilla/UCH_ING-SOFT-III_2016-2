package pe.egcc.appbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.appbs.dao.espec.PublicacionDaoEspec;
import pe.egcc.appbs.dao.espec.VentaDaoEspec;
import pe.egcc.appbs.model.Publicacion;
import pe.egcc.appbs.model.Venta;

@Service
public class VentaService {

  @Autowired
  private VentaDaoEspec ventaDao;
  
  @Autowired
  private PublicacionDaoEspec publiDao;
  
  public double conImporteVenta(int idventa){
    return ventaDao.conImporteVenta(idventa);
  }
  
  
  public void regVenta(Venta venta){
    Publicacion p = publiDao.getPublicacion(venta.getIdpublicacion());
    venta.setPrecio(p.getPrecio());
    venta.setDcto(0.0);
    venta.setTotal(venta.getPrecio() * venta.getCantidad());
    venta.setSubtotal(venta.getTotal() / 1.18);
    venta.setImpuesto(venta.getTotal() - venta.getSubtotal());
    ventaDao.grabar(venta);
  }
  
}

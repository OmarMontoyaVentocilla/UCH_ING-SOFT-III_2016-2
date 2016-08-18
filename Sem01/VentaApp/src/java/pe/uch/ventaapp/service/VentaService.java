package pe.uch.ventaapp.service;

public class VentaService {

  public double calcTotal(double precio, int cant) {
    return (precio * cant);
  }
  
  public double calcImporte(double precio, int cant) {
    double importe;
    importe = calcTotal(precio, cant)/1.18;
    return importe;
  }
  
  public double calcImpuesto(double precio, int cant) {
    double impuesto;
    impuesto = calcTotal(precio, cant)-calcImporte(precio, cant);
    return impuesto;
  }
  
}

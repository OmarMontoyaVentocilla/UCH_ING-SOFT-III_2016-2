package pe.egcc.appbs.model;

import java.util.Date;

public class Venta {

  private int idventa;
  private String cliente;
  private Date fecha;
  private int idempleado;
  private String idpublicacion;
  private int cantidad;
  private double precio;
  private double dcto;
  private double subtotal;
  private double impuesto;
  private double total;

  public Venta() {
  }

  public int getIdventa() {
    return idventa;
  }

  public void setIdventa(int idventa) {
    this.idventa = idventa;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public int getIdempleado() {
    return idempleado;
  }

  public void setIdempleado(int idempleado) {
    this.idempleado = idempleado;
  }

  public String getIdpublicacion() {
    return idpublicacion;
  }

  public void setIdpublicacion(String idpublicacion) {
    this.idpublicacion = idpublicacion;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public double getDcto() {
    return dcto;
  }

  public void setDcto(double dcto) {
    this.dcto = dcto;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }

  public double getImpuesto() {
    return impuesto;
  }

  public void setImpuesto(double impuesto) {
    this.impuesto = impuesto;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

}

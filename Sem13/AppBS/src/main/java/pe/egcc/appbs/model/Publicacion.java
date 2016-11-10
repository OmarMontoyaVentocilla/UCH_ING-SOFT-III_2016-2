package pe.egcc.appbs.model;

public class Publicacion {

  private String idpub;
  private String idtipo;
  private String titulo;
  private String autor;
  private int edicion;
  private double precio;
  private int stock;

  public Publicacion() {
  }

  public String getIdpub() {
    return idpub;
  }

  public void setIdpub(String idpub) {
    this.idpub = idpub;
  }

  public String getIdtipo() {
    return idtipo;
  }

  public void setIdtipo(String idtipo) {
    this.idtipo = idtipo;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getEdicion() {
    return edicion;
  }

  public void setEdicion(int edicion) {
    this.edicion = edicion;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

}

package pe.egcc.app.carrito;

public class CarritoItem {

    private String nombre;
    private double precio;
    private int cant;
    private double subtotal;

    public CarritoItem() {
    }

    public CarritoItem(String nombre, double precio, int cant, double subtotal) {
        this.nombre = nombre;
        this.precio = precio;
        this.cant = cant;
        this.subtotal = subtotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}

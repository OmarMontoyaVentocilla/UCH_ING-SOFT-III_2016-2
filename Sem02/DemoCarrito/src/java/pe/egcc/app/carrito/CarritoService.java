package pe.egcc.app.carrito;

import java.util.ArrayList;
import java.util.List;

public class CarritoService {

    private List<CarritoItem> lista;

    public CarritoService() {
        lista = new ArrayList<>();
    }
    
    public void addItem(CarritoItem item){
        item.setSubtotal(item.getPrecio() * item.getCant());
        lista.add(item);
    }

    public List<CarritoItem> getLista() {
        return lista;
    }

}

package pe.egcc.app.prueba;

import java.util.List;
import pe.egcc.app.model.Cliente;
import pe.egcc.app.service.ClienteService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public class Prueba03 {
  
  public static void main(String[] args) {
    ClienteService service = new ClienteService();
    
    // Consulta 1
    Cliente bean = service.getCliente("00011");
    System.out.println("Nombre: " + bean.getNombre());
    
    // Consulta 2
    bean.setCodigo("");
    bean.setPaterno("C");
    bean.setMaterno("");
    bean.setNombre("ED");
    List<Cliente> lista = service.getClientes(bean);
    
    for (Cliente o : lista) {
      System.out.println(o.getCodigo() + " | " + o.getPaterno() 
      + " | " + o.getMaterno() + " | " + o.getNombre());
    }
    
  }
}

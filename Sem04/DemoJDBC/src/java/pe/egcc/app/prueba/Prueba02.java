package pe.egcc.app.prueba;

import pe.egcc.app.service.PruebaService;

public class Prueba02 {

    public static void main(String[] args) {
        try {
            PruebaService service = new PruebaService();
            //service.regMensaje("Gustavo", "Todos", "Hay alguna preguna.");
            service.regMensaje2("Gustavo", "Bedon", "No te puedes ir.");
            System.out.println("Proceso ok.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}

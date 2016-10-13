package pe.egcc.mvc001.prueba;

import pe.egcc.mvc001.service.MateService;

public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    int n1 = 10;
    int n2 = 15;
    // Proceso
    MateService service = new MateService();
    int suma = service.sumar(n1, n2);
    // Reporte
    System.out.println("N1: " + n1);
    System.out.println("N2: " + n2);
    System.out.println("Suma: " + suma);
  }
}

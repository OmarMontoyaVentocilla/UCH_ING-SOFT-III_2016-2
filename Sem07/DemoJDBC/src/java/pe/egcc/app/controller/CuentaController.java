package pe.egcc.app.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.service.CuentaService;

@WebServlet(name = "CuentaController", urlPatterns = {"/CuentaRetiro"})
public class CuentaController extends HttpServlet {
  
  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      double importe = Double.parseDouble(request.getParameter("importe"));
      String clave = request.getParameter("clave");
      // Proceso
      CuentaService service = new CuentaService();
      service.registrarRetiro(cuenta, importe, clave, "0003");
      // Reporte
      request.setAttribute("mensaje", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procRetiro.jsp");
    rd.forward(request, response);
  } // Fin de service

} // Fin de CuentaController

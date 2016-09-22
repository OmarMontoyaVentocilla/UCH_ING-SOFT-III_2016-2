package pe.egcc.practica2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.service.CuentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
@WebServlet(urlPatterns = {"/Pregunta1", "/Pregunta2"})
public class PracticaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
      
    String path = request.getServletPath();
    switch(path){
      case "/Pregunta1":
        pregunta1(request,response);
        break;
      case "/Pregunta2":
        pregunta2(request,response);
        break;        
    }
    
  } // Fin de service

  private void pregunta1(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    try {
      // Dato
      String cuenta = request.getParameter("cuenta");
      // Proceso
      CuentaService service = new CuentaService();
      Map<String,Object> regCuenta = service.getCuentaPract2(cuenta);
      List<Map<String,Object>> movimientos = service.getMovimientosPract2(cuenta);
      request.setAttribute("cuenta", regCuenta);
      request.setAttribute("movimientos", movimientos);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("pregunta1.jsp");
    rd.forward(request, response);
  }

  private void pregunta2(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  
  
} // Fin de Servlet

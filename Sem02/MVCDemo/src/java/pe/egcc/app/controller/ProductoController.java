package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.model.Producto;
import pe.egcc.app.service.ProductoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
@WebServlet(name = "ProductoController", 
        urlPatterns = {"/ProductoTraerPorId", "/ProductoTraerPorNombre", 
          "/ProductoGrabar"})
public class ProductoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
  
    String path = request.getServletPath();
    if(path.equals("/ProductoTraerPorId")){
      traerPorId(request,response);
    } else if(path.equals("/ProductoTraerPorNombre")){
      traerPorNombre(request,response);
    } else if(path.equals("/ProductoGrabar")){
      grabar(request,response);
    }
  
  }

  private void traerPorId(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    try {
      // Dato
      int id = Integer.parseInt(request.getParameter("id"));
      // Proceso
      ProductoService service = new ProductoService();
      Producto bean = service.obtenerProducto(id);
      if(bean == null){
        throw new RuntimeException("ID no existe.");
      }
      request.setAttribute("model", bean);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  }

  private void traerPorNombre(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void grabar(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  
  
}

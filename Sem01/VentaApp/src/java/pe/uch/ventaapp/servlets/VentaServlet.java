package pe.uch.ventaapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.uch.ventaapp.service.VentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
@WebServlet(name = "VentaServlet", urlPatterns = {"/VentaServlet"})
public class VentaServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    // Datos
    double precio = Double.parseDouble(request.getParameter("precio"));
    int cant = Integer.parseInt(request.getParameter("cant"));

    // Proceso
    VentaService service = new VentaService();
    double importe = service.calcImporte(precio, cant);
    double impuesto = service.calcImpuesto(precio, cant);
    double total = service.calcTotal(precio, cant);

    // Reporte
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>VENTA</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>REPORTE DE VENTA</h1>");
    out.println("<p>Importe:" + importe + "</p>");
    out.println("<p>Impuesto:" + impuesto + "</p>");
    out.println("<p>Total:" + total + "</p>");
    out.println("<a href='index.html'>Volver</a>");
    out.println("</body>");
    out.println("</html>");
  }

}

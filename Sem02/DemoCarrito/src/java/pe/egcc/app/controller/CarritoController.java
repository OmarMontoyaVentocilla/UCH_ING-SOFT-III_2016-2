package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.egcc.app.carrito.CarritoItem;
import pe.egcc.app.carrito.CarritoService;

/**
 *
 * @author alumno
 */
@WebServlet(name = "CarritoController",
        urlPatterns = {"/CarritoAgregar", "/CarritoListado"})
public class CarritoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/CarritoAgregar")){
            carritoAgregar(request, response);
        } else if(path.equals("/CarritoListado")){
            carritoListado(request, response);
        }
    }

    private void carritoAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // CarritoItem
        CarritoItem item = new CarritoItem();
        item.setNombre(request.getParameter("nombre"));
        item.setPrecio(Double.parseDouble(request.getParameter("precio")));
        item.setCant(Integer.parseInt(request.getParameter("cant")));
        // Carrito
        CarritoService carrito;
        HttpSession session = request.getSession(true);
        if( session.getAttribute("carrito") == null){
            carrito = new CarritoService();
        } else {
            carrito = (CarritoService) session.getAttribute("carrito");
        }
        carrito.addItem(item);
        session.setAttribute("carrito", carrito);
        // Forward
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("agregar.jsp");
        rd.forward(request, response);
    }

    private void carritoListado(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

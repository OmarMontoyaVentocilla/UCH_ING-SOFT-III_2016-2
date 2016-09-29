package pe.egcc.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.model.Cliente;
import pe.egcc.app.service.ClienteService;

@WebServlet(name = "ClienteController",
        urlPatterns = {"/ClienteTraerUno", "/ClienteTraerVarios"})
public class ClienteController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {

    String path = request.getServletPath();

    if (path.equals("/ClienteTraerUno")) {
      clienteTraerUno(request, response);
    } else if (path.equals("/ClienteTraerVarios")) {
      clienteTraerVarios(request, response);
    }

  }

  private void clienteTraerUno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String codigo = null;
    try {
      // Datos
      codigo = request.getParameter("codigo");
      // Proceso
      ClienteService service = new ClienteService();
      Cliente bean = service.getCliente(codigo);
      if (bean == null) {
        throw new Exception("Codigo no existe.");
      }
      request.setAttribute("bean", bean);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    request.setAttribute("codigo", codigo);
    RequestDispatcher rd = request.getRequestDispatcher("conCliente.jsp");
    rd.forward(request, response);
  }

  private void clienteTraerVarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Cliente> lista = new ArrayList<Cliente>();
    try {
      // Datos
      Cliente bean = new Cliente();
      bean.setCodigo(request.getParameter("codigo"));
      bean.setPaterno(request.getParameter("paterno"));
      bean.setMaterno(request.getParameter("materno"));
      bean.setNombre(request.getParameter("nombre"));
      // Proceso
      ClienteService service = new ClienteService();
      lista = service.getClientes(bean);
      if (lista.isEmpty()) {
        throw new Exception("No hay datos.");
      }
      request.setAttribute("lista", lista);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("conClientes.jsp");
    rd.forward(request, response);
  
  }

}

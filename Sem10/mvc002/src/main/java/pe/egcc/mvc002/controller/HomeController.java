package pe.egcc.mvc002.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.egcc.mvc002.model.Venta;
import pe.egcc.mvc002.service.VentaService;


@Controller
public class HomeController {
	
  @Autowired
  private VentaService ventaService;
  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		return "panchito";
	}
	
	@RequestMapping(value="/procesar.uch", method=RequestMethod.POST)
	public String procesar(
	    @ModelAttribute Venta venta,
	    Model model){
	  
	  // Proceso
	  ventaService.procesar(venta);
	  // Reporte
	  model.addAttribute("venta", venta);
	  
	  return "panchito";
	}
	
	
}

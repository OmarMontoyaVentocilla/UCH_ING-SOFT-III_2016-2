package pe.egcc.appbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.appbs.service.VentaService;

@Controller
public class HomeController {
  
  @Autowired
  private VentaService ventaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/conImporte.htm", method = RequestMethod.POST)
	public String conImporte(
	    @RequestParam("idventa") int idventa,
	    Model model) {
	  
	  // Proceso
	  double importe = ventaService.conImporteVenta(idventa);
	  model.addAttribute("importe", importe);
	  
	  return "home";
	}
	
	
	
	
}

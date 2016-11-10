package pe.egcc.appbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.appbs.model.Publicacion;
import pe.egcc.appbs.service.PublicacionService;
import pe.egcc.appbs.service.VentaService;

@Controller
public class HomeController {
  
  @Autowired
  private VentaService ventaService;
  
  @Autowired
  private PublicacionService pubService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/conImporte.htm", method = RequestMethod.POST)
	public String conImporte(
	    @RequestParam("idventa") int idventa,
	    Model model) {
	  try{
  	  // Proceso
  	  double importe = ventaService.conImporteVenta(idventa);
  	  model.addAttribute("importe", importe);
	  } catch(Exception e){
	    model.addAttribute("error", e.getMessage());
	  }
	  return "home";
	}
	
	
	@RequestMapping(value = "/conPub.htm", method = RequestMethod.GET)
  public String conPublicaciones(Model model) {
	  model.addAttribute("bean", new Publicacion());
    return "conPublicaciones";
  }
	
	@RequestMapping(value = "/conPub.htm", method = RequestMethod.POST)
  public String conPublicaciones(
      @ModelAttribute Publicacion bean,
      Model model) {
	  
	  // Proceso
	  List<Publicacion> lista;
	  lista =  pubService.getPublicaciones(bean);
	  model.addAttribute("lista", lista);
	  
	  if(lista.isEmpty()){
	    model.addAttribute("mensaje", "No s eencontraron filas.");
	  }
	  
	  model.addAttribute("bean", bean);
	    
    return "conPublicaciones";
  }
	
	 @RequestMapping(value = "/conResumenVentas.htm", method = RequestMethod.GET)
	  public String conResumenVentas(Model model) {
	    model.addAttribute("lista", pubService.getResumenVentas());
	    return "conResumenVentas";
	  }
	
	
	
}

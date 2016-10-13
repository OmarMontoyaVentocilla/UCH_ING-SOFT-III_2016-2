package pe.egcc.mvc001.controller;

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

import pe.egcc.mvc001.service.MateService;

@Controller
public class HomeController {
	
  @Autowired
  private MateService mateService;
  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		return "panchito";
	}
	
	@RequestMapping(value="/procesar.uch", method=RequestMethod.POST)
	public String procesar(
	    @RequestParam("n1") int num1,
	    @RequestParam("n2") int num2,
	    Model model){
	  
	  // Proceso
	  int suma = mateService.sumar(num1, num2);
	  // Reporte
	  model.addAttribute("num1", num1);
	  model.addAttribute("num2", num2);
	  model.addAttribute("suma", suma);
	  
	  return "panchito";
	}
	
	
}

package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;

@Controller
public class HomeController {
	
	@GetMapping("/detalleVacante")
	public String godetalleVacante(Model model) {
		Vacante vacante=new Vacante();
		vacante.setId(1);
		vacante.setNombre("Licenciado en contabilidad");
		vacante.setDescripcion("Para realizar contabilidad de la empresa");
		vacante.setSalario(1234.00);
		model.addAttribute("detalleVacante_detalleVacante",vacante);
		return "detalleVacante";
	}
	
	@GetMapping("/listado")
	public String golistado(Model model) {
		ArrayList<String> titulos= new ArrayList<String>();
		titulos.add("ingeniero en sistemas");
		titulos.add("ingeniero en medio ambiente");
		titulos.add("licenciado en ciencias");
		model.addAttribute("listado_listado",titulos);
		return "listado";
	}
	
	@GetMapping("/")
	public String goHome(Model model) {
		String bienvenida="bienvenidos al sistema de busqueda de empleo";
		Double salario=234.00;
		model.addAttribute("bienvenida_Home",bienvenida);
		model.addAttribute("fecha_home",new Date());
		model.addAttribute("salario_home",salario);
		return "home";
	}
}

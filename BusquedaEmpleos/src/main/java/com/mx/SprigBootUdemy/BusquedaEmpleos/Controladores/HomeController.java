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
		ArrayList<Vacante> listVacante=new ArrayList<Vacante>();
		Vacante vacante=new Vacante();
		vacante.setId(1);
		vacante.setNombre("Licenciado en contabilidad");
		vacante.setDescripcion("Para realizar contabilidad de la empresa");
		vacante.setSalario(1234.00);
		vacante.setEstatus(true);
		vacante.setDestacado(false);
		
		Vacante vacante1=new Vacante();
		vacante1.setId(2);
		vacante1.setNombre("Ingeniero en sistemas");
		vacante1.setDescripcion("programas");
		vacante1.setSalario(10000.00);
		vacante1.setEstatus(false);
		vacante1.setDestacado(true);

		listVacante.add(vacante);
		listVacante.add(vacante1);
		model.addAttribute("detalleVacante_detalleVacante",listVacante);
		return "detalleVacante";
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

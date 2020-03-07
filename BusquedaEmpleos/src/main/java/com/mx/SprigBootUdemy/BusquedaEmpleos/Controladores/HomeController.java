package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.IUsuarioService;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.IVacantesService;

@Controller
public class HomeController {
	@Autowired
	private IVacantesService vacanteService;
	@Autowired
	private IUsuarioService usuarioService;
	@GetMapping("/detalleVacante")
	public String godetalleVacante(Model model) {
		List<Vacante> listVacante=vacanteService.buscarTodas();
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
		usuarioService.buscarTodosUsuarios();
		return "home";
	}

}

package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String goHome(Model model) {
		String bienvenida="bienvenidos al sistema de busqueda de empleo";
		model.addAttribute("bienvenida_Home",bienvenida);
		model.addAttribute("fecha_home",new Date());
		return "home";
	}
}

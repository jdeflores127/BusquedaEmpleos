package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="categorias")
public class CategoriasController {
	
	@GetMapping("/mostrarIndex")
	public String goMostrarIndex(Model model) {
		return "categorias/mostrarIndex";
	}
	@PostMapping("/save")
	public String goSave(Model model) {
		return "categorias/mostrarIndex";
	}
}

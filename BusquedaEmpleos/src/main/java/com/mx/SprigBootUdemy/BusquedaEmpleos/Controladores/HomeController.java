package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.ICategoriasService;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.IUsuarioService;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.IVacantesService;

@Controller
public class HomeController {
	@Autowired
	private IVacantesService vacanteService;
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private ICategoriasService categoriaService;
	@GetMapping("/detalleVacante")
	public String godetalleVacante(Model model) {
		List<Vacante> listVacante=vacanteService.buscarTodas();
		model.addAttribute("detalleVacante_detalleVacante",listVacante);
		return "detalleVacante";
	}	
	@GetMapping("/")
	public String goHome(Model model, Vacante vacante) {
		String bienvenida="bienvenidos al sistema de busqueda de empleo";
		Double salario=234.00;
		model.addAttribute("bienvenida_Home",bienvenida);
		model.addAttribute("fecha_home",new Date());
		model.addAttribute("salario_home",salario);
		usuarioService.buscarTodosUsuarios();
		vacanteService.buscarDestacados();
		model.addAttribute("detalleVacante_detalleVacante",vacanteService.buscarDestacados());
		model.addAttribute("detalleVacante_listaCategorias", categoriaService.buscarTodas());
		return "home";
	}
	@PostMapping("/buscarEmpleo")
	public String buscarEmpleo(Vacante vacante) {
		System.out.println("[buscarEmpleo] " + vacante.toString());
		vacanteService.BuscarXFiltro(vacante);
		return "home";
	}
	/*Metodo para que cuando el databinder se detecte, cambie los string a valores nulo*/
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}

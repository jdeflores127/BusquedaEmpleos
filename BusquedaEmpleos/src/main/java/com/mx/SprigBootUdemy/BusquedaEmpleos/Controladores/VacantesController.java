package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.IVacantesService;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	@Autowired
	private IVacantesService vacantesService;
	
	@GetMapping("/detalle/{id}")
	public String goDetalle(@PathVariable("id") int idvacante, Model model) {
		Vacante vacante=vacantesService.buscarXId(idvacante);	
		model.addAttribute("vacante_Detalle",vacante);
		return "descripcionVacante";
	}
	
	@GetMapping("/insertaVacante")
	public String goInsertaVacante(Vacante vacante) {
		return "vacantes/insertaVacante";
	}
	
	@GetMapping("/eliminarVacante")
	public String eliminarVacante(@RequestParam("id") int idVacante)
	{
		System.out.println("el id a eliminar es: "+idVacante);
		return "home";
	}
	@GetMapping("/modificarVacante")
	public String modificarVacante(@RequestParam("id") int idVacante)
	{
		System.out.println("el id a modificar es: "+idVacante);
		return "home";
	}
	
	@PostMapping("/guardarVacante")
	public String guardarVacante(Vacante vacante, BindingResult bindingResult, RedirectAttributes attributes) {
		String exitoso="exitoso";
		if(bindingResult.hasErrors()) {
			for(ObjectError error:bindingResult.getAllErrors())
				System.out.println("Ocurrio un error: "+error.getDefaultMessage());
			return "vacantes/insertaVacante";
		}
		System.out.println(vacante.toString());
		//Cuando se hace un redirect las varibles en el objeto model se pierden, por lo que hay que usar un atributo flash
		attributes.addFlashAttribute("guardarVacante_guardarVacante", exitoso);
		//se realiza peticion get a detalleVacante
		return "redirect:/detalleVacante";
	}
	//metodo para dar formato dd-mm-yyyy a las fechas que se usan para databinding
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		System.out.println("Inicia metodo initBinding");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,false));
	}
}

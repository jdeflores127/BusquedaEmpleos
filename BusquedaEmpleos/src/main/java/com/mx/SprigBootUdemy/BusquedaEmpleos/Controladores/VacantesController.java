package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.IVacantesService;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	@Autowired
	private IVacantesService vacantesService;
	@GetMapping("/detalle/{id}")
	public String goDetalle(@PathVariable("id") int idvacante) {
		vacantesService.buscarXId(idvacante);	
		return "home";
	}
	@GetMapping("/eliminarLista")
	public String eliminarLista(@RequestParam("id") int idVacante)
	{
		System.out.println("el id a eliminar es: "+idVacante);
		return "home";
	}
}

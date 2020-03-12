package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Categoria;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.ICategoriasService;

@Controller
@RequestMapping(value="categorias")
public class CategoriasController {
	@Autowired
	ICategoriasService categoriasService;
	
	@GetMapping("/insertarCategoria")
	public String insertarCategoria(Model model) {
		return "categorias/insertarCategoria";
	}
	public String eliminarCategoria(@PathVariable("id") int idCategoria) {
		return "categorias/eliminarCategoria";
	}
	public String modificarCategoria() {
		return "categorias/modificarCategoria";
	}
	public String guardarVacante(Vacante vacante) {
		return "categorias/mostrarTodas";
	} 
	@GetMapping("/mostrarTodas")
	public String mostrarTodas(Model model) {
		ArrayList<Categoria> categoria_list=categoriasService.buscarTodas();
		model.addAttribute("MostrarTodas_listCategorias", categoria_list);
		return "categorias/mostrarTodas";
	}
	@GetMapping("/buscarXid")
	public String buscarXId() {
		return "categorias/buscarXid";
	}
	
	
	@PostMapping("/guardarCategoria")
	public String guardarCategoria(Categoria categoria){
		System.out.println("categoria guardada: "+categoria.toString());
		categoriasService.guardar(categoria);
		return "categorias/insertarCategoria";
	}
	
	@PostMapping("/buscarCategoria")
	public String buscarCategoria(@RequestParam("buscarXid_id") int id, Model model) {
		ArrayList<Categoria> categoria_list=new ArrayList<Categoria>();
		Categoria categoria=categoriasService.buscarXId(id);
		categoria_list.add(categoria);
		model.addAttribute("MostrarTodas_listCategorias", categoria_list);
		return "categorias/mostrarTodas";
	}
	
	/*
	@PostMapping("/save")
	public String goSave(Model model,
						@RequestParam("nombre") String nombre,
						@RequestParam("descripcion") String descripcion) {
		System.out.println("Datos traidos del form");
		System.out.println("nombre: "+nombre);
		System.out.println("descripcion: "+descripcion);
		return "categorias/insertarCategoria";
	}*/
	
}

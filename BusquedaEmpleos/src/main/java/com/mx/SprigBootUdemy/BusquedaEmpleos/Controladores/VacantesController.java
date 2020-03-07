package com.mx.SprigBootUdemy.BusquedaEmpleos.Controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Categoria;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.ICategoriasService;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.IVacantesService;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios.VacantesServiceImpl;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Utileria.Utileria;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	@Autowired
	private IVacantesService vacantesService;
	@Autowired
	private ICategoriasService categoriasService;
	@Value("${busquedaEmpleos.rutaImagen}")
	private String ruta;
	@GetMapping("/detallnsertae/{id}")
	public String goDetalle(@PathVariable("id") int idvacante, Model model) {
		Vacante vacante=vacantesService.buscarXId(idvacante);	
		model.addAttribute("vacante_Detalle",vacante);
		return "descripcionVacante";
	}
	
	@GetMapping("/insertaVacante")
	public String goInsertaVacante(Vacante vacante, Model model) {
		ArrayList<Categoria> categoriaList=categoriasService.buscarTodas();
		model.addAttribute("InsertaVacante_categorias_list", categoriaList);
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
	public String guardarVacante(Vacante vacante, 
								@RequestParam("insertaVacante_imagen") MultipartFile imagen, 
								@RequestParam("insertaVacante_categoria_txt")int idCategoria,
								BindingResult bindingResult, 
								RedirectAttributes attributes) {
		
		String exitoso="exitoso";
		//Si ocurre algun error en el dataBinding
		if(bindingResult.hasErrors()) {
			for(ObjectError error:bindingResult.getAllErrors())
				System.out.println("Ocurrio un error: "+error.getDefaultMessage());
			return "vacantes/insertaVacante";
		}
		//Procesamiento de la imagen
		if(!imagen.isEmpty()) {
			String nombreImagen=Utileria.guardarArchivo(imagen, ruta);
			if(nombreImagen!=null) {
				vacante.setEmpresa(nombreImagen);
			}
		}
		Categoria categoria=new Categoria();
		categoria.setId(idCategoria);
		vacante.setCategoria(categoria);
		System.out.println(vacante.toString());
		vacantesService.guardar(vacante);
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

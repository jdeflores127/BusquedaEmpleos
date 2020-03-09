package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Repositorios.VacanteRepository;
@Service
public class VacantesServiceImpl implements IVacantesService{
	@Value("${busquedaEmpleos.paginacion}")
	private int paginas;
	@Value("${busquedaEmpleos.diasExpiracionDestacado}")
	private int diasExpiracion;
	@Autowired
	private VacanteRepository vacanteRepository;
	@Override
	public List<Vacante> buscarTodas() {
		Page<Vacante> pagina=vacanteRepository.findAll(PageRequest.of(0, paginas,Sort.by("nombre")));
		return pagina.getContent();
	}

	@Override
	public Vacante buscarXId(int id) {
		System.out.println("Buscaremos por id "+id);
		Optional<Vacante> vacanteOptional=vacanteRepository.findById(id);
		if(vacanteOptional.isPresent())
			return vacanteOptional.get();
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		vacanteRepository.save(vacante);
	}
	
	/*Obtiene la lista de vacantes destacadas si destacado está en true y la fecha de publicacion 
	y no hayan pasado n dias despues de la publicacion*/
	@Override
	public List<Vacante> buscarDestacados() {
		//fecha registro + 10 sea mayor a la fecha actual
		Calendar fechaActual=Calendar.getInstance();
		Calendar fechaAnterior=Calendar.getInstance();
		List<Vacante> listaVacantes=new ArrayList<>();

		fechaAnterior.add(Calendar.DAY_OF_MONTH, -diasExpiracion);
		System.out.println("la fecha anterior: "+fechaAnterior.getTime().toString());
		System.out.println("la fecha actual: "+fechaActual.getTime().toString());

		listaVacantes=vacanteRepository.findByDestacadoAndFechaBetween(true, fechaAnterior.getTime(), fechaActual.getTime());
		for(Vacante vacante_item:listaVacantes)
			System.out.println(vacante_item.toString());
		return listaVacantes;
	}

	@Override
	public void eliminarVacante(int id) {
		this.vacanteRepository.deleteById(id);
	}

	@Override
	public List<Vacante> BuscarXFiltro(Vacante vacante) {
		//en el select se ejecuta where descripcion Like %?%
		ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("descripcion", GenericPropertyMatchers.contains());
		Example<Vacante> example=Example.of(vacante, matcher);
		List<Vacante> listaVacantes=vacanteRepository.findAll(example);
		for(Vacante vacante_item:listaVacantes)
			System.out.println(vacante_item.toString());
		return listaVacantes;
	}

}

package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Repositorios.VacanteRepository;
@Service
public class VacantesServiceImpl implements IVacantesService{
	@Value("${busquedaEmpleos.paginacion}")
	private int paginas;
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

}

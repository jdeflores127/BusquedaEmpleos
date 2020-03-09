package com.mx.SprigBootUdemy.BusquedaEmpleos.Repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;

public interface VacanteRepository extends JpaRepository<Vacante,Integer>{
	public List<Vacante> findByDestacadoAndFechaBetween(boolean destacado, Date fechaAnterior, Date fechaActual);
	
}

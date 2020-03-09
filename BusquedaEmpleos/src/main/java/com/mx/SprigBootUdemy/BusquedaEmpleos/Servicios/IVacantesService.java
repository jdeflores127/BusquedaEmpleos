package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.List;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
public interface IVacantesService {
	public List<Vacante> buscarTodas();
	public Vacante buscarXId(int id);
	public void guardar(Vacante vacante);
	public List<Vacante> buscarDestacados();
	public void eliminarVacante(int id);
	public List<Vacante> BuscarXFiltro(Vacante vacante);
}

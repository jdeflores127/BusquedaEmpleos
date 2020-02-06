package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.ArrayList;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Vacante;
public interface IVacantesService {
	public ArrayList<Vacante> buscarTodas();
	public Vacante buscarXId(int id);
	public void guardar(Vacante vacante);
}

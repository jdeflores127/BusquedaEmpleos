package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.ArrayList;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Categoria;

public interface ICategoriasService {
	public ArrayList<Categoria> buscarTodas();
	public Categoria buscarXId(int id);
	public void guardar(Categoria categoria);
}

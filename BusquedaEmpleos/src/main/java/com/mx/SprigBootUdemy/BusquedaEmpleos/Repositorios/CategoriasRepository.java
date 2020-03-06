package com.mx.SprigBootUdemy.BusquedaEmpleos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer>{
	
}

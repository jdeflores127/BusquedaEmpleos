package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Categoria;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Repositorios.CategoriasRepository;
@Service
public class CategoriasServiceImpl implements ICategoriasService{
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	private ArrayList<Categoria> listCategorias;
	
	@Override
	public ArrayList<Categoria> buscarTodas() {
		//se busca ordenada por nombre
		ArrayList<Categoria> listCategorias=(ArrayList<Categoria>) categoriasRepository.findAll(Sort.by("nombre"));
		for(Categoria categoria_item : listCategorias)
			System.out.println(categoria_item.toString());
		return listCategorias;
	}

	@Override
	public Categoria buscarXId(int id) {
		Optional<Categoria> categoriaItem=categoriasRepository.findById(id);
		if(categoriaItem.isPresent())
			return (Categoria) categoriaItem.get();
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		System.out.println("se guarda el registro en la lista");
		categoriasRepository.save(categoria);
		System.out.println("se recarga la lista de categorias en memoria");
	}
}

package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Categoria;
@Service
public class CategoriasServiceImpl implements ICategoriasService{
	
	private ArrayList<Categoria> listCategorias=inicializarCategorias();
	
	@Override
	public ArrayList<Categoria> buscarTodas() {
		for(Categoria categoria_item : listCategorias)
			System.out.println(categoria_item.toString());
		return listCategorias;
	}

	@Override
	public Categoria buscarXId(int id) {
		for(Categoria categoria_item:listCategorias)
			if(categoria_item.getId()==id)
				return categoria_item;
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		System.out.println("se guarda el registro en la lista");
		this.listCategorias.add(categoria);
	}
	
	private ArrayList<Categoria> inicializarCategorias() {
		ArrayList<Categoria> listCategoria=new ArrayList<Categoria>();
		Categoria c1= new Categoria();
		c1.setNombre("Ventas");
		c1.setId(1);
		c1.setDescripcion("Categoria de ventas");
		Categoria c2= new Categoria();
		c2.setNombre("Programacion");
		c2.setId(2);
		c2.setDescripcion("Categoria de programacion");
		Categoria c3= new Categoria();
		c3.setNombre("Trabajo domestico");
		c3.setId(3);
		c3.setDescripcion("Categoria de domestico");
		listCategoria.add(c1);
		listCategoria.add(c2);
		listCategoria.add(c3);
		return listCategoria;
	}
}

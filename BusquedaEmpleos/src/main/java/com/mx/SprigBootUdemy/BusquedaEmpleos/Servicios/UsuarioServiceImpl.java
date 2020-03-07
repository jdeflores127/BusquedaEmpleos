package com.mx.SprigBootUdemy.BusquedaEmpleos.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Usuario;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Repositorios.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> buscarTodosUsuarios() {
		System.out.println("[UsuarioServiceImpl] se procede a imprimir la lista de usuarios");
		for(Usuario usuario_item:usuarioRepository.findAll())
			System.out.println(usuario_item.toString());
		return null;
	}

}

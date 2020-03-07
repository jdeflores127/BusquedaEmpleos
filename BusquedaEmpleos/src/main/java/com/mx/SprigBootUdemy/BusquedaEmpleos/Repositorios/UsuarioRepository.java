package com.mx.SprigBootUdemy.BusquedaEmpleos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}

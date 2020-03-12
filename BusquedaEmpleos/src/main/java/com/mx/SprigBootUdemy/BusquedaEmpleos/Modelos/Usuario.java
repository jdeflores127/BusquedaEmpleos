package com.mx.SprigBootUdemy.BusquedaEmpleos.Modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String email;
	private String username;
	private String password;
	private int estatus;
	private Date fecharegistro;
	//Lazy se inicializan los datos solo cuando son usados
	//la primera llave foranea debe ir la de la clase y la segunda llave debe ir la lista que se trata de obtener
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="usuarioperfil",
				joinColumns=@JoinColumn(name="idusuario"),
				inverseJoinColumns=@JoinColumn(name="idperfil"))
	private List<Perfil> perfiles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public Date getFechaRegistro() {
		return fecharegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fecharegistro = fechaRegistro;
	}
	public void agregarPerfil(Perfil perfil) {
		if(perfil==null)
			perfiles.add(perfil);
		else {
			perfiles=new ArrayList<Perfil>();
			perfiles.add(perfil);
		}
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", estatus=" + estatus + ", fechaRegistro=" + fecharegistro + ", perfiles="
				+ perfiles.toString() + "]";
	}
	
	
	
	
}

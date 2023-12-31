package com.cibertec.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String nickname;
	private String correo;
	private String contraseña;
	private String cargo;
	
	@OneToMany(mappedBy = "usuario")
	private List<Juego> juegos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Compra> compras;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String nombre, String apellido, String nickname, String correo, String contraseña,
			String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nickname = nickname;
		this.correo = correo;
		this.contraseña = contraseña;
		this.cargo = cargo;
	}
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nickname=" + nickname
				+ ", correo=" + correo + ", contraseña=" + contraseña + ", cargo=" + cargo + "]";
	}
	
	
	
	
	
	
}

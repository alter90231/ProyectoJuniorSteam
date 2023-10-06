package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "juegos")
public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String portada;
	private String descrip;	
	private String cateogoria;
	private double precio;	
	
	@ManyToOne
	private Usuario usuario;
	
	public Juego() {
		
	}
		
	public Juego(int id, String nombre, String portada, String descrip, String cateogoria, double precio,
			Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.portada = portada;
		this.descrip = descrip;
		this.cateogoria = cateogoria;
		this.precio = precio;
		this.usuario = usuario;
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
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getCateogoria() {
		return cateogoria;
	}
	public void setCateogoria(String cateogoria) {
		this.cateogoria = cateogoria;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", nombre=" + nombre + ", portada=" + portada + ", descrip=" + descrip
				+ ", cateogoria=" + cateogoria + ", precio=" + precio + "]";
	}
	
	
	
	
}

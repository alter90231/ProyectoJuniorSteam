package com.cibertec.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numero;
	private Date fecha;
	private double total;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "compra")
	private List<Detalle_compra> detalles;
	
	public Compra() {
		
	}

	public Compra(int id, String numero, Date fecha, double total) {
		super();
		this.id = id;
		this.numero = numero;
		this.fecha = fecha;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Detalle_compra> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle_compra> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", total=" + total + "]";
	}
	
	
	
}

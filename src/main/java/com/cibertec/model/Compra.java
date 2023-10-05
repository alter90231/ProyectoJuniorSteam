package com.cibertec.model;

import java.util.Date;

public class Compra {

	private int id;
	private String numero;
	private Date fecha;
	private double total;
	
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

	@Override
	public String toString() {
		return "Compra [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", total=" + total + "]";
	}
	
	
	
}

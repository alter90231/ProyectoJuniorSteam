package com.cibertec.service;


import java.util.List;

import com.cibertec.model.Compra;

public interface CompraService {
	List<Compra> findAll();
	Compra save (Compra compra);
	String generarNumeroCompra();
}

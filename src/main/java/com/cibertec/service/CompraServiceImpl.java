package com.cibertec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Compra;
import com.cibertec.repository.CompraRepository;

@Service
public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraRepository comreposy;
	
	@Override
	public Compra save(Compra compra) {
		return comreposy.save(compra);
	}

	@Override
	public List<Compra> findAll() {
		return comreposy.findAll();
	}
	
	public String generarNumeroCompra() {
		int numero = 0;
		String numeroConcatenado = "";
		
		List<Compra> compras = findAll();
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		compras.stream().forEach(c -> numeros.add(Integer.parseInt(c.getNumero())));
		
		if (compras.isEmpty()) {
			numero = 1;
		} else {
			numero = numeros.stream().max(Integer::compare).get();
			numero++;
		}
		
		if(numero<10) {
			numeroConcatenado = "000000000" + String.valueOf(numero);
		} else if(numero < 100) {
			numeroConcatenado = "000000000" + String.valueOf(numero);
		}else if(numero < 1000) {
			numeroConcatenado = "000000000" + String.valueOf(numero);
		}else if(numero < 10000) {
			numeroConcatenado = "000000000" + String.valueOf(numero);
		}
				
		
		return numeroConcatenado;
	}

}

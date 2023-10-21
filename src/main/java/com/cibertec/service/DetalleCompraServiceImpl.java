package com.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Detalle_compra;
import com.cibertec.repository.DetalleCompraRepository;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

	@Autowired
	private DetalleCompraRepository dcreposy;
	
	@Override
	public Detalle_compra save(Detalle_compra detalleCompra) {
		return dcreposy.save(detalleCompra);
	}

}

package com.cibertec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Juego;
import com.cibertec.repository.JuegosRepository;

@Service
public class JuegoServiceImpl implements JuegoService {

	@Autowired
	private JuegosRepository Jrepo;
	
	@Override
	public Juego save(Juego juego) {		
		return Jrepo.save(juego);
	}

	@Override
	public Optional<Juego> get(int id) {
		return Jrepo.findById(id);
	}

	@Override
	public void update(Juego juego) {
		Jrepo.save(juego);
		
	}

	@Override
	public void delete(int id) {
		Jrepo.deleteById(id);
		
	}

}

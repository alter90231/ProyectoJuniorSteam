package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.model.Juego;

public interface JuegoService {
	public Juego save( Juego juego);
	public Optional<Juego> get(Integer id);
	public void update(Juego juego);
	public void delete(int id);
	public List<Juego> findAll();

}

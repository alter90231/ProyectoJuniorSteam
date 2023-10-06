package com.cibertec.service;

import java.util.Optional;

import com.cibertec.model.Juego;

public interface JuegoService {
	public Juego save( Juego juego);
	public Optional<Juego> get(int id);
	public void update(Juego juego);
	public void delete(int id);
}

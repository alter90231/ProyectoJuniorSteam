package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Juego;

@Repository
public interface JuegosRepository extends JpaRepository<Juego, Integer> {

}

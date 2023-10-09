package com.cibertec.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.model.Juego;
import com.cibertec.model.Usuario;
import com.cibertec.service.JuegoService;

@Controller
@RequestMapping("/menu")
public class JuegoControlador {
	
	private final Logger LOGGER = LoggerFactory.getLogger(JuegoControlador.class);
	
	@Autowired
	private JuegoService juegoservice;
	
	@GetMapping("")
	public String Menu() {
		return "User/Menu";
	}
	
	@GetMapping("/agregar")
	public String Agregar() {
		return "User/Agregar";
	}
	
	@PostMapping("/guardar")
	public String guardar(Juego juego) {
		LOGGER.info("Este es el objeto juego {}", juego);
		Usuario u = new Usuario(1, "", "", "", "", "", "");
		juego.setUsuario(u);
		
		juegoservice.save(juego);
		return "redirect:/menu";
	}
}

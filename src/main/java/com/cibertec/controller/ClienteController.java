package com.cibertec.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.model.Juego;
import com.cibertec.service.JuegoService;

@Controller
@RequestMapping("/")
public class ClienteController {
	
	private final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private JuegoService juegoservice;
	
	@GetMapping("")
	public String menu(Model model) {
		
		model.addAttribute("juegos", juegoservice.findAll());
		
		return "Cliente/MenuCliente";
	}
	
	@GetMapping("VistaJuego/{id}")
	public String vistajuego(@PathVariable Integer id, Model model) {
		log.info("Id juego enviado {}", id);
		Juego juego = new Juego();
		Optional<Juego> juegoOp = juegoservice.get(id);
		juego = juegoOp.get();
		
		model.addAttribute("juego", juego);
		
		return "Cliente/VistaJuego";
	}
}

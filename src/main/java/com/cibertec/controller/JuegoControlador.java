package com.cibertec.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String Menu(Model model) {
		model.addAttribute("juegos", juegoservice.findAll());
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
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Juego juego = new Juego();
		Optional<Juego> ojuego = juegoservice.get(id);
		juego = ojuego.get();
		
		LOGGER.info("Se encontro el juego que busca: {}", juego);
		model.addAttribute("juego", juego);
		
		return "User/Editar";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(Juego juego) {
		juegoservice.update(juego);
		return "redirect:/menu";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable Integer id) {
		juegoservice.delete(id);
		return "redirect:/menu";
	}
}

package com.cibertec.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cibertec.model.Juego;
import com.cibertec.model.Usuario;
import com.cibertec.service.ImagenesService;
import com.cibertec.service.JuegoService;

@Controller
@RequestMapping("/menu")
public class JuegoControlador {
	
	private final Logger LOGGER = LoggerFactory.getLogger(JuegoControlador.class);
	
	@Autowired
	private JuegoService juegoservice;
	
	@Autowired
	private ImagenesService imagenservice;
	
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
	public String guardar(Juego juego, @RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto juego {}", juego);
		Usuario u = new Usuario(1, "", "", "", "", "", "");
		juego.setUsuario(u);
		
		if (juego.getId()==null) {
			String nombreImagen = imagenservice.guardarImagen(file);
			juego.setPortada(nombreImagen);
		}else {
			if(file.isEmpty()) {
				Juego j = new Juego();
				j = juegoservice.get(juego.getId()).get();
				juego.setPortada(j.getPortada());
			}else {
				String nombreImagen = imagenservice.guardarImagen(file);
				juego.setPortada(nombreImagen);
			}
		}
		
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
	public String actualizar(Juego juego, @RequestParam("img") MultipartFile file) throws IOException {
		if(file.isEmpty()) {
			Juego j = new Juego();
			j = juegoservice.get(juego.getId()).get();
			juego.setPortada(j.getPortada());
		}else {
			Juego j = new Juego();
			j = juegoservice.get(juego.getId()).get();
			if(!j.getPortada().equals("default.jpg")) {
				imagenservice.eliminarImagen(j.getPortada());
				
			}
			String nombreImagen = imagenservice.guardarImagen(file);
			juego.setPortada(nombreImagen);
		}
		
		juegoservice.update(juego);
		return "redirect:/menu";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable Integer id) {
		Juego j = new Juego();
		j = juegoservice.get(id).get();
		if(!j.getPortada().equals("default.jpg")) {
			imagenservice.eliminarImagen(j.getPortada());
			
		}
		
		juegoservice.delete(id);
		return "redirect:/menu";
	}
}

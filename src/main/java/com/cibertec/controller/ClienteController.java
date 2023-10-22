package com.cibertec.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.cibertec.model.Juego;
import com.cibertec.service.CompraService;
import com.cibertec.service.DetalleCompraService;
import com.cibertec.service.JuegoService;
import com.cibertec.service.UsuarioService;
import com.cibertec.model.Detalle_compra;
import com.cibertec.model.Compra;
import com.cibertec.model.Usuario;

@Controller
@RequestMapping("/")
public class ClienteController {
	
	private final Logger log = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private JuegoService juegoservice;
	
	@Autowired
	private UsuarioService uservice;
	
	@Autowired
	private CompraService cservice;
	
	@Autowired 
	private DetalleCompraService dcservice;
	
	
	List<Detalle_compra> detalles = new ArrayList<Detalle_compra>();
	
	Compra compra = new Compra();
	
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
	
	@PostMapping("/orden")
	public String AñadirOrden(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
		Detalle_compra detalle_compra = new Detalle_compra();
		Juego juego = new Juego();
		double Total = 0;
		
		Optional<Juego> optionalJuego = juegoservice.get(id);
		log.info("Juego Añadido : {}", optionalJuego.get());
		log.info("Cantidad a comprar: {}", cantidad);
		juego = optionalJuego.get();
		
		detalle_compra.setCantidad(cantidad);
		detalle_compra.setPrecio(juego.getPrecio());
		detalle_compra.setNombre(juego.getNombre());
		detalle_compra.setTotal(juego.getPrecio()*cantidad);
		detalle_compra.setJuegos(juego);
		
		Integer idJuego = juego.getId();
		boolean ordenado = detalles.stream().anyMatch(p -> p.getJuegos().getId()== idJuego);
		
		if (!ordenado) {
			detalles.add(detalle_compra);
		}
		
		
		
		Total = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		compra.setTotal(Total);
		model.addAttribute("orden", detalles);
		model.addAttribute("compra", compra);
		
		return "Cliente/Compras";
	}
	
	@GetMapping("/quitarOrden/orden/{id}")
	public String QuitarOrden(@PathVariable Integer id, Model model) {
		
		List<Detalle_compra> Nuevodetalles = new ArrayList<Detalle_compra>();
		
		for(Detalle_compra Detalleorden: detalles){
			if(Detalleorden.getJuegos().getId() != id) {
				Nuevodetalles.add(Detalleorden);
			}
		}
		
		detalles = Nuevodetalles;
		
		double Total = 0;
		Total = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		compra.setTotal(Total);
		model.addAttribute("orden", detalles);
		model.addAttribute("compra", compra);
		
		return "Cliente/Compras";
	}
	
	@GetMapping("/Compra")
	public String Compra(Model model) {
		model.addAttribute("orden", detalles);
		model.addAttribute("compra", compra);
		return "Cliente/Compras";
	}
	
	@GetMapping("/ListaOrden")
	public String ListaOrden(Model model){
		Usuario usuario = uservice.findById(1).get();
		
		model.addAttribute("orden", detalles);
		model.addAttribute("compra", compra);
		model.addAttribute("user", usuario);
		
		return "Cliente/ListaOrdenes";
	}
	
	@GetMapping("/guardarCompra")
	public String GuardarCompra() {
		Date fecha = new Date();
		compra.setFecha(fecha);
		compra.setNumero(cservice.generarNumeroCompra());
		
		Usuario usuario = uservice.findById(1).get();
		
		compra.setUsuario(usuario);
		cservice.save(compra);
		
		for(Detalle_compra dc:detalles) {
			dc.setCompras(compra);
			dcservice.save(dc);
		}
		
		compra = new Compra();
		detalles.clear();
		
		return "redirect:/";
	}
	
	@PostMapping("/buscar")
	public String buscarJuego(@RequestParam String nombre, Model model) {
		log.info("Nombre buscado del juego: {}", nombre);
		List<Juego> juegos = juegoservice.findAll().stream().filter( j -> j.getNombre().contains(nombre)).collect(Collectors.toList());
		model.addAttribute("juegos", juegos);
		return "Cliente/MenuCliente";
	}
}

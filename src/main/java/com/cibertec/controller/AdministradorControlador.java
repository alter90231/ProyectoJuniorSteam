package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.model.Juego;

import com.cibertec.service.JuegoService;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {

	
	
	public String Index() {		
		return "Admin/MenuAdmin";
	}
}

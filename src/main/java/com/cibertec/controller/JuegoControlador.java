package com.cibertec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class JuegoControlador {
	
	@GetMapping("")
	public String Menu() {
		return "User/Menu";
	}
}
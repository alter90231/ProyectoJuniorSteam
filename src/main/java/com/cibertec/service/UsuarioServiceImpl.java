package com.cibertec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Usuario;
import com.cibertec.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository ureposy;

	@Override
	public Optional<Usuario> findById(Integer id) {
		return ureposy.findById(id);
	}
	


}

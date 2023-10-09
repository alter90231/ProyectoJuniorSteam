package com.cibertec.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenesService {
	private String folder="img//";
	
	public String guardarImagen(MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			byte[] bytes=file.getBytes();
			Path path = Paths.get(folder + file.getOriginalFilename());
			Files.write(path, bytes);
			return file.getOriginalFilename();
		
		}
		
		return "default.jpg";
	}
	
	public void eliminarImagen(String name) {
		String ruta = "img//";
		File file = new File(ruta+name);
		file.delete();		
	}
}

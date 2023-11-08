package com.livros.Gerenciamento.de.Livros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livros.Gerenciamento.de.Livros.entities.Livros;
import com.livros.Gerenciamento.de.Livros.service.LivrosService;

@RestController
@RequestMapping("/livros")
public class LivrosController {

	private final LivrosService livrosService;
	
	@Autowired
	public LivrosController (LivrosService livrosService) {
		this.livrosService = livrosService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livros> getLivros(@PathVariable long id) {
		Livros livros = livrosService.getLivrosById(id);
		if (livros != null) {
			return ResponseEntity.ok(livros);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Livros creatProduct (@RequestBody Livros livros) {
		return livrosService.saveLivros(livros);
	}

	//Utilizando o ResponseEntity e RequestEntity
	@GetMapping
		public ResponseEntity<List<Livros>> getAllLivros(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Livros> livros = livrosService.getAllLivros();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livros);
		}
		
	@PutMapping("/{id}")
		public Livros updateLivros(@PathVariable Long id, @RequestBody Livros livros) {
		    return livrosService.updateLivros(id, livros);
		}
	
	@DeleteMapping("/{id}")
	public void deleteLivros(@PathVariable Long id) {
		livrosService.deleteLivros(id);
	}
	

	
}
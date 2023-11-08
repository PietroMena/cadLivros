package com.livros.Gerenciamento.de.Livros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livros.Gerenciamento.de.Livros.entities.Livros;
import com.livros.Gerenciamento.de.Livros.repositories.LivrosRepository;

import java.util.Optional;


@Service
public class LivrosService {

	private final LivrosRepository livrosRepository;
	
	@Autowired
	public LivrosService(LivrosRepository livrosRepository) {
		this.livrosRepository = livrosRepository;
	}
	
	//preparando as buscas por id
	public Livros getLivrosById(Long id) {
		return livrosRepository.findById(id).orElse(null);
	}
	
		//preparando a busca geral
		public List<Livros> getAllLivros(){
			return livrosRepository.findAll();
		}
		
		//salvando o jooo
		public Livros saveLivros(Livros livros) {
			return livrosRepository.save(livros);
		}
		
		//excluindo o jogo
		public void deleteLivros(Long id) {
			livrosRepository.deleteById(id);
		}
		// fazendo o update do jogo com o optional
		public Livros updateLivros(Long id, Livros novoLivros) {
	        Optional<Livros> LivrosOptional = livrosRepository.findById(id);
	        if (LivrosOptional.isPresent()) {
	        	Livros LivrosExistente = LivrosOptional.get();
	        	LivrosExistente.setDescricao(novoLivros.getDescricao());
	        	LivrosExistente.setIsbn(novoLivros.getIsbn());          
	            return livrosRepository.save(LivrosExistente); 
	        } else {
	            return null; 
	        }
	    }
}
package com.livros.Gerenciamento.de.Livros.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Livros")
public class Livros {

	//atributos da classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String descricao;
	

	private String isbn;
	
	
	//metodos da classe
	
	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setId(Long id) {
		this.id = id ;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao ;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn ;
	}
	
	
}
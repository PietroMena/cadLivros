package com.livros.Gerenciamento.de.Livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livros.Gerenciamento.de.Livros.entities.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{
}
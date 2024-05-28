package com.example.prjavaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.prjavaliacao.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	@Query(value = "SELECT * FROM Categoria l WHERE lower(l.nome) LIKE %:nome%", nativeQuery = true)
	List<Categoria> buscarPorNome(@Param("nome") String nome);
	
	@Query("SELECT l FROM Categoria l WHERE l.descricao = ?1")
	List<Categoria> findByDescricao(String descricao);
	
}

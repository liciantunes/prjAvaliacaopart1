package com.example.prjavaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.prjavaliacao.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	@Query(value = "SELECT * FROM Autor l WHERE lower(l.nome) LIKE %:nome%", nativeQuery = true)
	List<Autor> buscarPorNome(@Param("nome") String titulo);
	
	@Query("SELECT l FROM Autor l WHERE l.pais = ?1")
	List<Autor> findByPais(String pais);
	
}

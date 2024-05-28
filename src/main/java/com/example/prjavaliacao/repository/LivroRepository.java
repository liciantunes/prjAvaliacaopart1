package com.example.prjavaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.prjavaliacao.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(value = "SELECT * FROM Livro l WHERE lower(l.titulo) LIKE %:titulo%", nativeQuery = true)
	List<Livro> buscarPorTitulo(@Param("titulo") String titulo);
	
	@Query("SELECT l FROM Livro l WHERE l.ano = ?1")
	List<Livro> findByAno(String ano);

}

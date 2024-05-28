package com.example.prjavaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prjavaliacao.entities.Categoria;
import com.example.prjavaliacao.repository.CategoriaRepository;

@Service
public class CategoriaService {

private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria saveCategoria(Categoria livro) {
        return categoriaRepository.save(livro);
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void deleteCategoria(Long id) {
    	categoriaRepository.deleteById(id);
    }
    
    public List<Categoria> buscarPorNome (String nome) {
    	return categoriaRepository.buscarPorNome(nome);
    }
    
    public List<Categoria> buscarPorDescricao(String descricao) {
    	return categoriaRepository.findByDescricao(descricao);
    }
}

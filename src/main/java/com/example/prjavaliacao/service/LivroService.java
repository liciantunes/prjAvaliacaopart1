package com.example.prjavaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prjavaliacao.entities.Livro;
import com.example.prjavaliacao.repository.LivroRepository;

@Service
public class LivroService {

private final LivroRepository livroRepository;
	
	@Autowired
	public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro getLivroById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public void deleteLivro(Long id) {
    	livroRepository.deleteById(id);
    }
    
    public List<Livro> buscarPorTitulo (String titulo) {
    	return livroRepository.buscarPorTitulo(titulo);
    }
    
    public List<Livro> buscarPorAno(String ano) {
    	return livroRepository.findByAno(ano);
    }
    
}

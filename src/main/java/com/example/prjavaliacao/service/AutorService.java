package com.example.prjavaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prjavaliacao.entities.Autor;
import com.example.prjavaliacao.repository.AutorRepository;

@Service
public class AutorService {

private final AutorRepository autorRepository;
	
	@Autowired
	public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public void deleteAutor(Long id) {
    	autorRepository.deleteById(id);
    }
    
    public List<Autor> buscarPorNome (String nome) {
    	return autorRepository.buscarPorNome(nome);
    }
    
    public List<Autor> buscarPorPais(String pais) {
    	return autorRepository.findByPais(pais);
    }
}

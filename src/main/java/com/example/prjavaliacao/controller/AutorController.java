package com.example.prjavaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prjavaliacao.entities.Autor;
import com.example.prjavaliacao.service.AutorService;


@RestController
@RequestMapping("/autor")
public class AutorController {

	private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/{id}")
    public Autor getAutor(@PathVariable Long id) {
        return autorService.getAutorById(id);
    }
    
    @GetMapping("/nome/{nome}")
    public List<Autor> buscarPorNome(@PathVariable String nome) {
    	return autorService.buscarPorNome(nome);
    }
    
    @GetMapping("/pais/{pais}")
    public List<Autor> buscarPorPais(@PathVariable String pais) {
    	return autorService.buscarPorPais(pais);
    }
    
    @PostMapping("/")
    public Autor createProduct(@RequestBody Autor autor) {
        return autorService.saveAutor(autor);
    }

}

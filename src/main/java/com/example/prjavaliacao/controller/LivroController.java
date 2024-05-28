package com.example.prjavaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prjavaliacao.entities.Livro;
import com.example.prjavaliacao.service.LivroService;


@RestController
@RequestMapping("/livro")
public class LivroController {

	private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/")
    public Livro createProduct(@RequestBody Livro livro) {
        return livroService.saveLivro(livro);
    }

    @GetMapping("/{id}")
    public Livro getLivro(@PathVariable Long id) {
        return livroService.getLivroById(id);
    }
    
    @GetMapping("/titulo/{titulo}")
    public List<Livro> buscarPorTitulo(@PathVariable String titulo) {
    	return livroService.buscarPorTitulo(titulo);
    }
    
    
    @GetMapping("/ano/{ano}")
    public List<Livro> buscarPorAno(@PathVariable String ano) {
    	return livroService.buscarPorAno(ano);
    }
}

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
import com.example.prjavaliacao.entities.Categoria;
import com.example.prjavaliacao.service.AutorService;
import com.example.prjavaliacao.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/")
    public Categoria createProduct(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Categoria getCategoria(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }
    
    @GetMapping("/nome/{nome}")
    public List<Categoria> buscarPorNome(@PathVariable String nome) {
    	return categoriaService.buscarPorNome(nome);
    }
    
    @GetMapping("/descricao/{descricao}")
    public List<Categoria> buscarPorDescricao(@PathVariable String descricao) {
    	return categoriaService.buscarPorDescricao(descricao);
    }
}

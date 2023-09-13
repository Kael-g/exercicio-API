package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.LivroModel;
import com.biblioteca.biblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {

    @Autowired
    LivrosService livrosService;

    @GetMapping(path = "/livros")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<LivroModel> retornaTodosLivros(){
        return livrosService.retornarLivros();
    }

    @GetMapping(path = "/livros/{id}")
    @PreAuthorize("permitAll()")
    public Optional<LivroModel> retornaLivroPorId(@PathVariable Long id){
        return livrosService.retornarPorId(id);
    }

    @PostMapping(path = "/livros")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public LivroModel registraNovoLivro(@RequestBody LivroModel livroModel){
        return livrosService.cadastrar(livroModel);
    }

    @PutMapping(path = "/livros/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public LivroModel alteraLivro(@PathVariable Long id,
                                      @RequestBody LivroModel livroModel){

        return livrosService.alterarDado(id, livroModel);
    }

    @DeleteMapping(path = "/livros/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletaLivro(@PathVariable Long id){
        livrosService.deletar(id);
    }
}

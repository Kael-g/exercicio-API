package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.LivroModel;
import com.biblioteca.biblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {
    @Autowired
    LivrosRepository livrosRepository;

    public List<LivroModel> retornarLivros(){
        return  livrosRepository.findAll();
    }

    public Optional<LivroModel> retornarPorId(Long id){
        return livrosRepository.findById(id);
    }

    public LivroModel cadastrar(LivroModel livroModel){
        return livrosRepository.save(livroModel);
    }

    public LivroModel alterarDado(Long id, LivroModel livroModel){
        LivroModel livro = retornarPorId(id).get();

        if(livroModel.getNome() != null){
           livro.setNome(livroModel.getNome());
        }
        if(livroModel.getAutor() != null){
            livro.setAutor(livroModel.getAutor());
        }
        if(livroModel.getDataLancamento() != null){
            livro.setDataLancamento(livroModel.getDataLancamento());
        }

        return livrosRepository.save(livro);
    }


    public void deletar(Long id){
        livrosRepository.deleteById(id);
    }
}

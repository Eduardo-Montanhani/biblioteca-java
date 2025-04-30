package com.unialfa.biblioteca.service;


import com.unialfa.biblioteca.model.Autor;
import com.unialfa.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public Autor salvarAutor(Autor autor){
        return repository.save(autor);
    }
    public List<Autor> listarAutor(){
        return repository.findAll();
    }

    public Autor buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void removerPorId(Long id) {
        repository.deleteById(id);
    }
}
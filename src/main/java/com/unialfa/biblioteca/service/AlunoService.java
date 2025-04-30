package com.unialfa.biblioteca.service;

import com.unialfa.biblioteca.model.Aluno;
import com.unialfa.biblioteca.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno salvarAluno(Aluno aluno){
        return repository.save(aluno);
    }
    public List<Aluno> listarAluno(){
        return repository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void removerPorId(Long id) {
        repository.deleteById(id);
    }
}

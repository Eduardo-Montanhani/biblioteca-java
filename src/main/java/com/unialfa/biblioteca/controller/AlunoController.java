package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Aluno;
import com.unialfa.biblioteca.service.AlunoService;
import com.unialfa.biblioteca.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("listaAlunos",
                "Lista de Alunos");
        model.addAttribute("listaDeAlunos",
                alunoService.listarAluno());
        return "aluno/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Aluno aluno){
        model.addAttribute("cadastroAlunos",
                "Cadastro de Alunos");
        model.addAttribute("listaDeCursos",
                cursoService.listarCurso());
        return "/aluno/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(Aluno aluno){
        alunoService.salvarAluno(aluno);
        return "redirect:/aluno/lista";
    }

    @GetMapping("alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        model.addAttribute("cadastroAlunos",
                "Cadastro de Alunos");
        model.addAttribute("aluno",
                alunoService.buscarPorId(id));
        return "/aluno/formulario";
    }

    @GetMapping("remover/{id}")
    public String remover(@PathVariable Long id){
        alunoService.removerPorId(id);
        return "redirect:/aluno/lista";
    }
}

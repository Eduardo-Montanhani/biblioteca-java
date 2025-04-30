package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Curso;
import com.unialfa.biblioteca.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoService serviceCurso;

    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("cursoMain",
                "Lista de Cursos");

        model.addAttribute("listaDeCursos",
                serviceCurso.listarCurso());
        return "curso/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Curso curso){
        model.addAttribute("cursoMain",
                "Cadastro de Cursos");

        return "curso/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(Curso curso){
        serviceCurso.salvarCurso(curso);
        return "redirect:/curso/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        model.addAttribute("cursoMain",
                "Cadastro de Cursos");
        model.addAttribute("curso", serviceCurso.buscarPorId(id));
        return "curso/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id){
        serviceCurso.removerPorId(id);
        return "redirect:/curso/lista";
    }
}

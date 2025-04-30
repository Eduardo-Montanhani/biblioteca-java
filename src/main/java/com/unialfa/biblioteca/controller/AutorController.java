package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Autor;
import com.unialfa.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("autor")
public class AutorController {
    @Autowired
    private AutorService serviceAutor;

    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("autorMain",
                "Lista de Autores");

        model.addAttribute("listaDeAutores", serviceAutor.listarAutor());
        return "autor/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Autor autor){
        model.addAttribute("autorMain",
                "Cadastro de Autores");

        return "autor/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(Autor autor){
        serviceAutor.salvarAutor(autor);
        return "redirect:/autor/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        model.addAttribute("autorMain", "Cadastro de Autores");
        model.addAttribute("listaDeEditoras", serviceAutor.listarAutor());
        return "redirect:/autor/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id){
        serviceAutor.removerPorId(id);
        return "redirect:/autor/lista";
    }
}



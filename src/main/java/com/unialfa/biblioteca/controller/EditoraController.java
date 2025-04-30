package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Editora;
import com.unialfa.biblioteca.service.EditoraService;
import com.unialfa.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("editora")
public class EditoraController {

    @Autowired
    private EditoraService serviceEditora;
    @Autowired
    private LivroService serviceLivro;

    @GetMapping("lista")
    public String iniciarLista(Model model){
        model.addAttribute("editoraMain",
                "Lista de Editoras");
        model.addAttribute("listaDeEditoras",
                serviceEditora.listarEditora());
        return "editora/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Editora editora){
        model.addAttribute("editoraMain",
                "Cadastro de Editoras");
        model.addAttribute("listaDeEditoras",
                serviceEditora.listarEditora());
        return "/editora/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(Editora editora){
        serviceEditora.salvarEditora(editora);
        return "redirect:/editora/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        model.addAttribute("editoraMain",
                "Cadastro de Editoras");
        model.addAttribute("listaDeEditoras",
                serviceEditora.listarEditora());

        return "/editora/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id){
        serviceEditora.removerPorId(id);
        return "redirect:/editora/lista";
    }
}

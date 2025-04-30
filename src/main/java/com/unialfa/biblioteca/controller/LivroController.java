package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Livro;
import com.unialfa.biblioteca.service.AutorService;
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
    @RequestMapping("livro")
    public class LivroController {
        @Autowired
        private LivroService serviceLivro;
        @Autowired
        private AutorService serviceAutor;
        @Autowired
        private EditoraService serviceEditora;

        @GetMapping("/lista")
        public String iniciarLista(Model model){
            model.addAttribute("listaLivros",
                    "Lista de Livros");

            model.addAttribute("listaDeLivros",
                    serviceLivro.listarLivro());
            return "livro/lista";
        }

        @GetMapping("/formulario")
        public String iniciarFormulario(Model model, Livro livro){
            model.addAttribute("listaLivros",
                    "Cadastro de Livros");

            return "livro/formulario";
        }

        @PostMapping("/salvar")
        public String salvar(Livro livro){
            serviceLivro.salvarLivro(livro);
            return "redirect:/livro/lista";
        }

        @GetMapping("/alterar/{id}")
        public String alterar(@PathVariable Long id, Model model){
            model.addAttribute("cadastroLivros",
                    "Cadastro de Livros");
            model.addAttribute("livro", serviceLivro.buscarPorId(id));
            return "livro/formulario";
        }

        @GetMapping("/remover/{id}")
        public String remover(@PathVariable Long id){
            serviceLivro.removerPorId(id);
            return "redirect:/livro/lista";
        }
    }


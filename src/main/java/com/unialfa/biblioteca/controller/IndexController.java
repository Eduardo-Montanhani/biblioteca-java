package com.unialfa.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String iniciar(Model model){
        model.addAttribute("central",
                "Biblioteca Acadêmica UniALFA");
        return "index";
    }}


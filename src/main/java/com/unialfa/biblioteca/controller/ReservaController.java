package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Reserva;
import com.unialfa.biblioteca.repository.ReservaRepository;
import com.unialfa.biblioteca.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reserva")
public class ReservaController {
    @Autowired
   private ReservaRepository repository;
    @Autowired
    private ReservaService serviceReserva;


    @GetMapping("/lista")
    public String iniciarLista(Model model){
        model.addAttribute("listaReservas",
                "Lista de Reservas");

        model.addAttribute("listaDeReservas",
                serviceReserva.listarReserva());
        return "reserva/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Reserva reserva){
        model.addAttribute("listaReservas",
                "Cadastro de Reservas");

        return "reserva/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(Reserva reserva){
        serviceReserva.salvarReserva(reserva);
        return "redirect:/reserva/lista";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model){
        model.addAttribute("cadastroReservas",
                "Cadastro de Reservas");
        model.addAttribute("reserva", serviceReserva.buscarPorId(id));
        return "reserva/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id){
        serviceReserva.removerPorId(id);
        return "redirect:/reserva/lista";
    }
}
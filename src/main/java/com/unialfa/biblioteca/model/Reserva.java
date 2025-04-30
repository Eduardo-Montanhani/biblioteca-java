package com.unialfa.biblioteca.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include

    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate dataInicio;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate dataFim;
    private String observacao;

}

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
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_aluno")
    private Long id;
    private Integer ra;
    private String nome;
    private String senha;
    private String endereco;
    private String cidade;
    private String uf;
    private String telefone;
    @ManyToOne
    @JoinColumn(name= "id_curso")
    private Curso curso;

}


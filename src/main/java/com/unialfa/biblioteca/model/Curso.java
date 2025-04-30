package com.unialfa.biblioteca.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_curso")
    private Long id;
    private String nome;
    private String coordenador;
    private Integer duracao;

    @Override
    public String toString() {
        return id +"-"+ nome;
    }
}

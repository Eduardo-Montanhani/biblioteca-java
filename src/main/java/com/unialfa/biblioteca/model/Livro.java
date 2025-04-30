package com.unialfa.biblioteca.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_livro")
    private Long id;
    private String titulo;
    private String subTitulo;
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;
    private String categoria;
    private String local;
    private Integer ano;
}

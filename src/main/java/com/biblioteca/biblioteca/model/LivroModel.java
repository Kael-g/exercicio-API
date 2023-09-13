package com.biblioteca.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name= "TB_LIVROS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String autor;

    @Column(length = 50, nullable = false)
    private LocalDate dataLancamento;
}

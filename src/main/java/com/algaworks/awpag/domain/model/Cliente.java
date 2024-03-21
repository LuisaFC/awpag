package com.algaworks.awpag.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//Entidade jakarta persistence
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//Lombo gerando getters and setters
@Getter
@Setter
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    @Column(name = "fone")
    private String telefone;

}

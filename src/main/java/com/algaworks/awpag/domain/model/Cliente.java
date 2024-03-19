package com.algaworks.awpag.domain.model;

import lombok.Getter;
import lombok.Setter;


//Lombo gerando getters and setters
@Getter
@Setter
public class Cliente {

    private long id;
    private String nome;
    private String email;
    private String telefone;

}

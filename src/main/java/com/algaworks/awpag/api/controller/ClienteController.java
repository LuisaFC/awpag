package com.algaworks.awpag.api.controller;

import com.algaworks.awpag.domain.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//Torna a classe capaz de tratar requisições http
@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    //Quando bater no caminho /clientes irá rodar o método listar
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return manager.createQuery("from Cliente", Cliente.class).getResultList();
    }
}

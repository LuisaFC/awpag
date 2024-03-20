package com.algaworks.awpag.api.controller;

import com.algaworks.awpag.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//Torna a classe capaz de tratar requisições http
@RestController
public class ClienteController {

    //Quando bater no caminho /clientes irá rodar o método listar
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Joao Souza");
        cliente1.setEmail("joao@gmail.com");
        cliente1.setTelefone("21 9999-1111");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setEmail("maria@gmail.com");
        cliente2.setTelefone("21 9999-2222");

        return Arrays.asList(cliente1, cliente2);
    }
}

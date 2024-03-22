package com.algaworks.awpag.api.controller;

import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//gera construtor
@AllArgsConstructor
//Torna a classe capaz de tratar requisições http
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository clienteRepository;


    //Quando bater no caminho /clientes irá rodar o método listar
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        //Optional -> Pode ter algo ou estar vazio
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        //manipulado status de resposta
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @ResponseStatus(HttpStatus.CREATED) //definindo status http
    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            // Se nao existir entao retorna not found
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(clienteId);

        return ResponseEntity.noContent().build();
    }
}

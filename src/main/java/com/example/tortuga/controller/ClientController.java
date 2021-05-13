package com.example.tortuga.controller;

import com.example.tortuga.entity.TortugaClient;
import com.example.tortuga.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Scope(value = "session")
@RestController
public class ClientController {

    private ClientService service;

    public ClientController(@Autowired ClientService clientsService) {
        this.service = clientsService;
    }

    @GetMapping("/clients")
    public ResponseEntity<Collection<TortugaClient>> getAllClients() {
        Collection<TortugaClient> tortugaClients = service.getAllClients();
        return tortugaClients != null && !tortugaClients.isEmpty() ?
                new ResponseEntity<>(tortugaClients, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<TortugaClient> getClientById(@PathVariable long id) {
        Optional<TortugaClient> clientOptional = service.getClientById(id);
        return clientOptional.isPresent() ?
                new ResponseEntity<>(clientOptional.get(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<?> updateClient(@PathVariable long id,
                                          @RequestBody TortugaClient tortugaClient) {
        return service.updateClient(id, tortugaClient) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable long id) {
        return service.deleteById(id) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/clients")
    public ResponseEntity<?> addClient(@RequestBody TortugaClient tortugaClient) {
        return service.addClient(tortugaClient) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

package com.github.alkhanm.movver.resources.controller;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.services.ClientService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    private Client findByNameOrPhoneNumber(){
        return null;
    }

    @PostMapping
    private Client save(){
        return null;
    }

    @PatchMapping
    private Client update(){
        return null;
    }

    @PutMapping
    private Client replace(){
        return null;
    }

    @DeleteMapping
    private boolean delete(){
        return false;
    }
}

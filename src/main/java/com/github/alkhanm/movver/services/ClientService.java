package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }


    private Client findByNameOrPhoneNumber(){
        return null;
    }

    private Client save(){
        return null;
    }

    private Client update(){
        return null;
    }

    private Client replace(){
        return null;
    }

    private boolean delete(){
        return false;
    }

}

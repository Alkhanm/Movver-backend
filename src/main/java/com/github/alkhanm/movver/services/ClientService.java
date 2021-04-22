package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> findAllBy(){
        return repository.findAll();
    }

    public Client findByPhoneNumber(String phoneNumber){
        return repository.findByPhoneNumber(phoneNumber);
    }

    public Client save(Client Client){
        return repository.save(Client);
    }
}

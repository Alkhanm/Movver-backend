package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.User;
import com.github.alkhanm.movver.repositories.ClientRepository;
import com.github.alkhanm.movver.services.exceptions.ResourceAlreadyExistsException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService implements UserService<Client> {
    private final ClientRepository repository;
    private final PasswordEncoder encoder;

    public ClientService(ClientRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<Client> findAllBy(){
        return repository.findAll();
    }

    public Client findByPhoneNumber(String phoneNumber){
        return repository.findByPhoneNumber(phoneNumber);
    }


   @Transactional
   @Override public Client save(Client c){
        try {
            Client client = (Client) c.toSave(encoder);
            return repository.save(client);
        } catch (ConstraintViolationException | IllegalArgumentException ex){
            throw new ResourceAlreadyExistsException();
        }
    }
}

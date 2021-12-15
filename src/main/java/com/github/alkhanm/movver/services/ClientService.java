package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.Client;
import com.github.alkhanm.movver.repositories.ClientRepository;
import com.github.alkhanm.movver.services.exceptions.InvalidRequestException;
import com.github.alkhanm.movver.services.exceptions.ResourceAlreadyExistsException;
import com.github.alkhanm.movver.services.exceptions.ResourceNotFoundException;
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
        return repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Nem um cliente correspondente foi encontrado"));
    }


   @Transactional
   @Override public Client save(Client c){
        try {
            Client client = (Client) c.toSave(encoder);
            return repository.save(client);
        } catch (ConstraintViolationException ex){
            throw new ResourceAlreadyExistsException("Um mesmo número de telefone já está associado a outra conta.");
        } catch (IllegalArgumentException ex){
            throw new InvalidRequestException("Os valores enviados são inválidos");
        }
    }

    @Override public Client update(long id, Client user) {
        return null;
    }

    @Override
    public void delete(Long identification) {

    }
}

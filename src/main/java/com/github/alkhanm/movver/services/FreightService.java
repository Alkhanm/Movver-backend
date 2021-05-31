package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.Client;
import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.repositories.FreightRepository;
import com.github.alkhanm.movver.services.exceptions.ResourceAlreadyExistsException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FreightService {
    private final FreightRepository repository;
    private final AuthenticatorService authenticatorService;

    public FreightService(FreightRepository repository, AuthenticatorService authenticatorService) {
        this.repository = repository;
        this.authenticatorService = authenticatorService;
    }

    public List<Freight> list(){
        Client userAuthenticated = (Client) authenticatorService.getUserAuthenticated();
        return repository.findFreightByClient(userAuthenticated);
    }

   @Transactional
   public Freight save(Freight freight){
        try {
            return repository.save(freight);
        } catch (ConstraintViolationException | IllegalArgumentException ex){
            throw new ResourceAlreadyExistsException();
        }
    }
}

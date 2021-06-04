package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.Client;
import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.repositories.FreightRepository;
import com.github.alkhanm.movver.services.exceptions.ResourceAlreadyExistsException;
import com.github.alkhanm.movver.services.exceptions.ResourceNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Freight> list(Pageable pageable){
        Client client= (Client) authenticatorService.getUserAuthenticated();
        return repository.findFreightByClient(client, pageable);
    }

    public Freight findById(Long id){
        return repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public Freight update(Long id, Freight newFreight){
        boolean exists = repository.existsById(id) && id == newFreight.getId();
        if (exists) return repository.save(newFreight);
        else throw new ResourceNotFoundException();
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

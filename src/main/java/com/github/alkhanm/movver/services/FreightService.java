package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.entities.Freight;
import com.github.alkhanm.movver.repositories.FreightRepository;
import com.github.alkhanm.movver.services.exceptions.ResourceAlreadyExistsException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FreightService {
    private final FreightRepository repository;

    public FreightService(FreightRepository repository) {
        this.repository = repository;
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

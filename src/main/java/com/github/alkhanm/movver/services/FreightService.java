package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.Client;
import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.User;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.repositories.FreightRepository;
import com.github.alkhanm.movver.services.exceptions.InvalidRequestException;
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

    public Page<Freight> listAllByStatus(String status, Pageable pageable){
        try {
            FreightStatusEnum statusEnum = FreightStatusEnum.create(status);
            return repository.findAllByStatus(statusEnum, pageable);
        } catch (IllegalArgumentException ex){
            throw new InvalidRequestException("Não há nem um status correspondente");
        }
    }

    public Page<Freight> listByUser(Pageable pageable){
        User user = authenticatorService.getUserAuthenticated();
        return repository.findFreightsByUser(user.getPhoneNumber(), pageable);
    }

    public Freight findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nem um frete correspondente foi encontrado"));
    }

    @Transactional
    public Freight update(Long id, Freight newFreight){
        boolean exists = repository.existsById(id) && id.equals(newFreight.getId());
        if (exists) return repository.save(newFreight);
        else throw new ResourceNotFoundException("Nem um frete correspondente foi encontrado");
    }

   @Transactional
   public Freight save(Freight freight){
        try {
            return repository.save(freight);
        } catch (ConstraintViolationException ex){
            throw new ResourceAlreadyExistsException("Conflito ao salvar um frete já existente");
        } catch (IllegalArgumentException ex){
            throw new InvalidRequestException("Os valores enviados são inválidos");
        }
    }
}

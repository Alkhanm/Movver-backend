package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.Driver;
import com.github.alkhanm.movver.domain.transference.FreightResponse;
import com.github.alkhanm.movver.repositories.DriverRepository;
import com.github.alkhanm.movver.services.exceptions.InvalidRequestException;
import com.github.alkhanm.movver.services.exceptions.ResourceAlreadyExistsException;
import com.github.alkhanm.movver.services.exceptions.ResourceNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements UserService<Driver> {
    private final DriverRepository repository;
    private final PasswordEncoder encoder;

    public DriverService(DriverRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<Driver> findAllBy() {
        return repository.findAll();
    }

    public Driver findByPhoneNumber(String phoneNumber){
        return repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Nem um motorista correspondente foi encontrado"));
    }

    @Override public Driver save(Driver d) {
        try {
            Driver driver = (Driver) d.toSave(encoder);
            return repository.save(driver);
        } catch (ConstraintViolationException ex){
            throw new ResourceAlreadyExistsException("Um mesmo número de telefone já está associado a outra conta.");
        } catch (IllegalArgumentException ex){
            throw new InvalidRequestException("Os valores enviados são inválidos");
        }
    }

    @Override public Driver update(long id, Driver driver) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A atualização não é possível, pois nem um motorista correspondente foi encontrado"));

        return this.save(driver);
    }

    @Override public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A deleção não é possível, pois nem um motorista correspondente foi encontrado"));

        repository.deleteById(id);
    }

}

package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public List<Driver> findAllBy(){
        return repository.findAll();
    }

    public Driver findByPhoneNumber(String phoneNumber){
        return repository.findByPhoneNumber(phoneNumber);
    }

    public Driver save(Driver driver){
        return repository.save(driver);
    }
}

package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.repositories.DriverRepository;
import com.github.alkhanm.movver.services.mapper.DriverMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository repository;

    public DriverService(DriverRepository repository, DriverMapper mapper) {
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

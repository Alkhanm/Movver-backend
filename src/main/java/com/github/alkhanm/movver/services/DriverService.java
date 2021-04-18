package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.repositories.DriverRepository;
import com.github.alkhanm.movver.services.mapper.DriverMapper;
import com.github.alkhanm.movver.services.request.DriverRequest;
import com.github.alkhanm.movver.services.request.DriverResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository repository;
    private final DriverMapper mapper;

    public DriverService(DriverRepository repository, DriverMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Driver> findAllBy(){
        return null;
    }

    public Driver findByPhoneNumber(String phoneNumber){
        return repository.findByPhoneNumber(phoneNumber);
    }

    public Driver save(DriverRequest driverRequest){
        Driver driver = mapper.fromRequest(driverRequest);
        return repository.save(driver);
    }

    public Driver update(Driver driver){
        return repository.save(driver);
    }

    public Driver replace(Driver driver){
        return null;
    }

    public boolean delete(Driver driver){
        return false;
    }

}

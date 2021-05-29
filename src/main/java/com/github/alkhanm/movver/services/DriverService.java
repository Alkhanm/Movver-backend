package com.github.alkhanm.movver.services;

import com.github.alkhanm.movver.domain.Driver;
import com.github.alkhanm.movver.repositories.DriverRepository;
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
        return repository.findByPhoneNumber(phoneNumber);
    }

    @Override public Driver save(Driver d) {
        Driver driver = (Driver) d.toSave(encoder);
        return repository.save(driver);
    }
}

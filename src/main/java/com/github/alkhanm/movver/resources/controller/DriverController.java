package com.github.alkhanm.movver.resources.controller;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.services.DriverService;

public class DriverController {
    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    private Driver findByUsernameOrPhoneNumber(){
        return null;
    }

    private Driver save(){
        return null;
    }

    private Driver update(){
        return null;
    }

    private Driver replace(){
        return null;
    }

    private boolean delete(){
        return false;
    }
}

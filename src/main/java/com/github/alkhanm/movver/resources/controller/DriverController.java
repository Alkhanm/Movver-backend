package com.github.alkhanm.movver.resources.controller;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.services.mapper.DriverMapper;
import com.github.alkhanm.movver.services.request.DriverResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.alkhanm.movver.services.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService service;
    private final DriverMapper mapper;

    public DriverController(DriverService service, DriverMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    private @ResponseBody
    List<DriverResponse> findAllBy(){
        return mapper.driverResponseList(service.findAllBy());
    }

    @GetMapping("/search")
    private @ResponseBody
    DriverResponse findByPhoneNumber(@RequestParam String phoneNumber){
        Driver driver = service.findByPhoneNumber(phoneNumber);
        return mapper.driverToResponse(driver);
    }

    @PostMapping
    private @ResponseBody
    DriverResponse save(){
        return null;
    }

    @PatchMapping
    private @ResponseBody
    DriverResponse update(){
        return null;
    }

    @PutMapping
    private @ResponseBody
    DriverResponse replace(){
        return null;
    }

    @DeleteMapping
    private @ResponseStatus
    boolean delete(){
        return false;
    }
}

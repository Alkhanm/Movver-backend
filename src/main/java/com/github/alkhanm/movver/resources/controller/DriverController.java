package com.github.alkhanm.movver.resources.controller;

import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.domain.entities.mapper.DriverMapper;
import com.github.alkhanm.movver.domain.entities.transference.DriverResponse;
import com.github.alkhanm.movver.services.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService service;
    private final DriverMapper mapper = DriverMapper.INSTANCE;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping
    private @ResponseBody
    List<DriverResponse> findAllBy(){
        List<DriverResponse> responseList = mapper.toResponseList((service.findAllBy()));
        return responseList;
    }

    @GetMapping("/search")
    private @ResponseBody
    DriverResponse findByPhoneNumber(@RequestParam String phoneNumber){
        Driver driver = service.findByPhoneNumber(phoneNumber);
        DriverResponse driverResponse = mapper.toResponse(driver);
        return driverResponse;
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

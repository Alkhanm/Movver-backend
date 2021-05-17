package com.github.alkhanm.movver.resources.controllers;

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
        return mapper.toResponseList((service.findAllBy()));
    }

    @GetMapping("/search")
    private @ResponseBody
    DriverResponse findByPhoneNumber(@RequestParam String phoneNumber){
        Driver driver = service.findByPhoneNumber(phoneNumber);
        return mapper.toResponse(driver);
    }

    @PostMapping
    private @ResponseBody
    DriverResponse save(@RequestBody Driver requestDriver){
        Driver driver = service.save(requestDriver);
        return mapper.toResponse(driver);
    }
}

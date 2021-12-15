package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.Driver;
import com.github.alkhanm.movver.domain.transference.FreightResponse;
import com.github.alkhanm.movver.services.DriverService;
import com.github.alkhanm.movver.services.exceptions.InvalidRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService service;
    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping
    private @ResponseBody
    List<Driver> findAllBy(){
        return service.findAllBy();
    }

    @GetMapping("/{phoneNumber}")
    private @ResponseBody Driver findBy(@PathVariable String phoneNumber){
        return service.findByPhoneNumber(phoneNumber);
    }

    @PostMapping
    private @ResponseBody
    Driver save(@RequestBody Driver request){
        if (request == null) throw new InvalidRequestException("O corpo da requisição está vazio");
        return service.save(request);
    }

    @PatchMapping("/{id}")
    private @ResponseBody Driver update(@PathVariable long id, @RequestBody Driver request){
        if (request == null) throw new InvalidRequestException("O corpo da requisição está vazio");
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    private @ResponseBody void delete(@PathVariable long id){
        service.delete(id);
    }
}
package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.mapper.ClientMapper;
import com.github.alkhanm.movver.domain.entities.transference.ClientResponse;
import com.github.alkhanm.movver.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;
    private final ClientMapper mapper =  ClientMapper.INSTANCE;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    private @ResponseBody
    List<ClientResponse> findAllBy(){
        return mapper.toResponseList(service.findAllBy());
    }

    @GetMapping("/search")
    private @ResponseBody
    ClientResponse findByPhoneNumber(@RequestParam String phoneNumber){
        Client client = service.findByPhoneNumber(phoneNumber);
        return mapper.toResponse(client);
    }

    @PostMapping
    private @ResponseBody
    ClientResponse save(@RequestBody Client request){
        Client client = service.save(request);
        return mapper.toResponse(client);
    }
}

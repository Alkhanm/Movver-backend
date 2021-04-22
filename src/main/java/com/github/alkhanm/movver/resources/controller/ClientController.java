package com.github.alkhanm.movver.resources.controller;

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
        List<ClientResponse> responseList = mapper.toResponseList(service.findAllBy());
        return responseList;
    }

    @GetMapping("/search")
    private @ResponseBody
    ClientResponse findByPhoneNumber(@RequestParam String phoneNumber){
        Client client = service.findByPhoneNumber(phoneNumber);
        ClientResponse clientResponse = mapper.toResponse(client);
        return clientResponse;
    }

    @PostMapping
    private @ResponseBody
    ClientResponse save(){
        return null;
    }

    @PatchMapping
    private @ResponseBody
    ClientResponse update(){
        return null;
    }

    @PutMapping
    private @ResponseBody
    ClientResponse replace(){
        return null;
    }

    @DeleteMapping
    private @ResponseStatus
    boolean delete(){
        return false;
    }
}

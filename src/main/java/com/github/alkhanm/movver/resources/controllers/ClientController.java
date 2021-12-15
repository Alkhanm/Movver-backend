package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.Client;
import com.github.alkhanm.movver.domain.mapper.ClientMapper;
import com.github.alkhanm.movver.domain.transference.ClientResponse;
import com.github.alkhanm.movver.services.ClientService;
import com.github.alkhanm.movver.services.exceptions.InvalidRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    // Retorna uma lista contendo todos os clientes do sistema
    @GetMapping
    private @ResponseBody
    List<ClientResponse> findAllBy(){
        return mapper.toResponseList(service.findAllBy());
    }

    // Retorna um único cliente através do seu identificador (ID/Número de telefone)
    @GetMapping("/{phoneNumber}")
    private @ResponseBody
    ClientResponse findByPhoneNumber(@PathVariable String phoneNumber){
        Client client = service.findByPhoneNumber(phoneNumber);
        return mapper.toResponse(client);
    }

    // Salva um cliente no banco de dados
    @PostMapping
    private @ResponseBody
    ClientResponse save(@RequestBody Client request){
        if (request == null) throw new InvalidRequestException("O corpo da requisição está vazio");
        Client client = service.save(request);
        return mapper.toResponse(client);
    }
}

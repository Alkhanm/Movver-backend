package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.Client;
import com.github.alkhanm.movver.domain.mapper.ClientMapper;
import com.github.alkhanm.movver.domain.transference.ClientResponse;
import com.github.alkhanm.movver.services.ClientService;
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

    @GetMapping
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    List<ClientResponse> findAllBy(){
        return mapper.toResponseList(service.findAllBy());
    }

    @GetMapping("/search")
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    ClientResponse findByPhoneNumber(@RequestParam String phoneNumber){
        Client client = service.findByPhoneNumber(phoneNumber);
        return mapper.toResponse(client);
    }

    @PostMapping
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    ClientResponse save(@RequestBody Client request){
        Client client = service.save(request);
        return mapper.toResponse(client);
    }
}

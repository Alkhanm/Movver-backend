package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.domain.mapper.FreightMapper;
import com.github.alkhanm.movver.domain.transference.FreightResponse;
import com.github.alkhanm.movver.services.FreightService;
import com.github.alkhanm.movver.services.exceptions.InvalidRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freights")
public class FreightController {
    private final FreightService service;

    // Esse objeto mapeia as classes de frete (FREIGHT), transformando-as em representações mais leves e concisas
    private final FreightMapper mapper = FreightMapper.INSTANCE;

    public FreightController(FreightService service) {
        this.service = service;
    }

    // Retorna todos os fretes realizados pelo usuário (cliente ou motorista)
    // Esse método é paginável. Exemplo: localhost:8080/freights?sort=id,asc&size=3
    @GetMapping
    private @ResponseBody
    Page<FreightResponse> getAllUserFreights(@ParameterObject Pageable pageable) {
        return service.listByUser(pageable).map(mapper::toResponse);
    }
    // Retorna todos os fretes que estão em determinado status
    @GetMapping({"/search"})
    private @ResponseBody
    Page<FreightResponse> getAllFreightsByStatus(@RequestParam(required = false) String status, @ParameterObject Pageable pageable){
        if (status != null) return service.listAllByStatus(status, pageable).map(mapper::toResponse);
        throw new InvalidRequestException("Parâmetro de pesquisa invalido ou nulo");
    }

    // Confirma o frete
    @PostMapping
    private @ResponseBody
    FreightResponse confirm(@RequestBody Freight freightRequest){
        Freight freightConfirmed = freightRequest.confirm();
        return mapper.toResponse(service.save(freightConfirmed));
    }

    // Inicia o frete
    @PatchMapping("/{id}/start")
    private @ResponseBody
    FreightResponse start(@PathVariable Long id){
        Freight freightStarted = service.findById(id).confirm().start();
        return mapper.toResponse(service.save(freightStarted));
    }

    // Finaliza o frete
    @PatchMapping("/{id}/finish")
    private @ResponseBody
    FreightResponse finish(@PathVariable Long id){
        Freight freight = service.findById(id);
        return mapper.toResponse(freight.finish());
    }

    // Cancela o frete
    @DeleteMapping("/{id}")
    private @ResponseBody
    FreightResponse cancel(@PathVariable Long id){
        Freight freightCanceled = service.findById(id).cancel();
        return mapper.toResponse(service.save(freightCanceled));
    }
}

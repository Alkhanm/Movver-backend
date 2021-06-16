package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.design.patterns.states.FreightConfirmedState;
import com.github.alkhanm.movver.domain.design.patterns.states.FreightStartedState;
import com.github.alkhanm.movver.domain.mapper.FreightMapper;
import com.github.alkhanm.movver.domain.transference.FreightResponse;
import com.github.alkhanm.movver.services.FreightService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/freights")
public class FreightController {
    private final FreightService service;
    private final FreightMapper mapper = FreightMapper.INSTANCE;

    public FreightController(FreightService service) {
        this.service = service;
    }

    @GetMapping
    private @ResponseBody //localhost:8080/freights?sort=id,asc&size=3
    Page<FreightResponse> findAll(@ParameterObject Pageable pageable){
        return service.list(pageable).map(mapper::toResponse);
    }

    @PostMapping
    private @ResponseBody
    FreightResponse confirm(@RequestBody Freight freightRequest){
        Freight freightConfirm = freightRequest.confirm();
        return mapper.toResponse(service.save(freightConfirm));
    }

    @PatchMapping("/{id}/start")
    private @ResponseBody
    FreightResponse start(@PathVariable Long id){
        Freight freight = service.findById(id);
        return mapper.toResponse(service.save(freight.confirm().start()));
    }

    @PatchMapping("/{id}/finish")
    private @ResponseBody
    FreightResponse finish(@PathVariable Long id){
        Freight freight = service.findById(id);
        return mapper.toResponse(service.update(id, freight.confirm().start().finish()));
    }

    @DeleteMapping("/{id}")
    private @ResponseBody
    FreightResponse cancel(@PathVariable Long id){
        Freight freightCanceled = service.findById(id).cancel();
        return mapper.toResponse(service.save(freightCanceled));
    }
}

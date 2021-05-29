package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.mapper.FreightMapper;
import com.github.alkhanm.movver.domain.transference.FreightResponse;
import com.github.alkhanm.movver.services.FreightService;
import org.springframework.web.bind.annotation.*;

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
    private @ResponseBody
    List<FreightResponse> findAll(){
        System.out.println(service.list());
        return mapper.toResponseList(service.list());
    }

    @PostMapping
    private @ResponseBody
    FreightResponse save(@RequestBody Freight requestFreight){
        return mapper.toResponse(service.save(requestFreight));
    }
}

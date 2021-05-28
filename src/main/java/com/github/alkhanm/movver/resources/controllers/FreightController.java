package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.entities.Freight;
import com.github.alkhanm.movver.domain.entities.FreightResponse;
import com.github.alkhanm.movver.domain.entities.mapper.FreightMapper;
import com.github.alkhanm.movver.services.FreightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freights")
public class FreightController {
    private final FreightService service;

    public FreightController(FreightService service) {
        this.service = service;
    }

    @PostMapping
    private @ResponseBody
    FreightResponse save(@RequestBody Freight requestFreight){
        System.out.println(requestFreight);
        FreightResponse response = FreightMapper.INSTANCE.toResponse(service.save(requestFreight));
        System.out.println(response);
        return response;
    }
}

package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.mapper.FreightMapper;
import com.github.alkhanm.movver.domain.transference.FreightResponse;
import com.github.alkhanm.movver.services.FreightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freights")
public class FreightController {
    private final FreightService service;
    private final FreightMapper mapper = FreightMapper.INSTANCE;

    public FreightController(FreightService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody //localhost:8080/freights?sort=id,asc&size=3
    Page<FreightResponse> findAll(@ParameterObject Pageable pageable){
        return service.list(pageable).map(mapper::toResponse);
    }

    @PostMapping
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    FreightResponse confirm(@RequestBody Freight freightRequest){
        Freight freightConfirmed = freightRequest.confirm();
        return mapper.toResponse(service.save(freightConfirmed));
    }

    @PatchMapping("/{id}/start")
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    FreightResponse start(@PathVariable Long id){
        Freight freightStarted = service.findById(id).confirm().start();
        return mapper.toResponse(service.save(freightStarted));
    }

    @PatchMapping("/{id}/finish")
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    FreightResponse finish(@PathVariable Long id){
        Freight freight = service.findById(id);
        return mapper.toResponse(freight.finish());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    FreightResponse cancel(@PathVariable Long id){
        Freight freightCanceled = service.findById(id).cancel();
        return mapper.toResponse(service.save(freightCanceled));
    }
}

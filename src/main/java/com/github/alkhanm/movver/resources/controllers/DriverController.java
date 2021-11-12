package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.Driver;
import com.github.alkhanm.movver.domain.mapper.DriverMapper;
import com.github.alkhanm.movver.domain.transference.DriverResponse;
import com.github.alkhanm.movver.services.DriverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService service;
    private final DriverMapper mapper = DriverMapper.INSTANCE;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    List<DriverResponse> findAllBy(){
        return mapper.toResponseList((service.findAllBy()));
    }

    @GetMapping("/search")
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    DriverResponse findByPhoneNumber(@RequestParam String phoneNumber){
        Driver driver = service.findByPhoneNumber(phoneNumber);
        return mapper.toResponse(driver);
    }

    @PostMapping
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    DriverResponse save(@RequestBody Driver requestDriver){
        Driver driver = service.save(requestDriver);
        return mapper.toResponse(driver);
    }
}

package com.github.alkhanm.movver.domain.entities.transference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleResponse {
    @JsonSerialize final VehicleModelEnum model;
    @JsonSerialize final int capacity;
    @JsonSerialize final String licensePlate;
    @JsonSerialize final String color;
    @JsonSerialize final boolean truckBodyWorkOpen;
}

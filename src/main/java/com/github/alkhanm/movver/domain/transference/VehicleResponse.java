package com.github.alkhanm.movver.domain.transference;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class VehicleResponse {
    private final String model;
    private final String truckBodyWork;
    private final int capacity;
    private final String licensePlate;
    private final String color;

    public VehicleResponse(String model, String truckBodyWork, int capacity, String licensePlate, String color) {
        this.model = model;
        this.truckBodyWork = truckBodyWork;
        this.capacity = capacity;
        this.licensePlate = licensePlate;
        this.color = color;
    }
}

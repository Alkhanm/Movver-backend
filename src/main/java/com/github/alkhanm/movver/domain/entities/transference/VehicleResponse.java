package com.github.alkhanm.movver.domain.entities.transference;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import lombok.Getter;

public class VehicleResponse {
    //Aqui o modelo do veiculo é retornado apenas como seu valor textual (enum -> string)
    @Getter final String model;
    @Getter final int capacity;
    @Getter final String licensePlate;
    @Getter final String color;
    @Getter final boolean truckBodyWorkOpen;

    public VehicleResponse(
            VehicleModelEnum model,
            int capacity,
            String licensePlate,
            String color,
            boolean truckBodyWorkOpen) {
        this.model = model.toString();
        this.capacity = capacity;
        this.licensePlate = licensePlate;
        this.color = color;
        this.truckBodyWorkOpen = truckBodyWorkOpen;
    }

}

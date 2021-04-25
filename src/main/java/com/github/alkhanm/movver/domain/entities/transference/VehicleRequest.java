package com.github.alkhanm.movver.domain.entities.transference;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import lombok.Getter;

public class VehicleRequest {
    //Aqui o modelo do veiculo é retornado apenas como seu valor textual (enum -> string)
    @Getter final VehicleModelEnum model;
    @Getter final int capacity;
    @Getter final String licensePlate;
    @Getter final String color;
    @Getter final boolean truckBodyWorkOpen;

    public VehicleRequest(
            String model,
            int capacity,
            String licensePlate,
            String color,
            boolean truckBodyWorkOpen) {
        this.model = VehicleModelEnum.to(model);
        this.capacity = capacity;
        this.licensePlate = licensePlate;
        this.color = color;
        this.truckBodyWorkOpen = truckBodyWorkOpen;
    }

}

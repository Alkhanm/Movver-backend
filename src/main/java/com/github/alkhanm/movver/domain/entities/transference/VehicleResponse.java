package com.github.alkhanm.movver.domain.entities.transference;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.domain.enums.VehicleTruckBodyEnum;
import lombok.Getter;

public class VehicleResponse {
    //Aqui o modelo do veiculo é retornado apenas como seu valor textual (enum -> string)
    @Getter final String model;
    @Getter final String truckBodyWork;
    @Getter final int capacity;
    @Getter final String licensePlate;
    @Getter final String color;

    public VehicleResponse(
            VehicleModelEnum model,
            int capacity,
            String licensePlate,
            String color,
            VehicleTruckBodyEnum truckBodyWork) {
        this.model = model.toString();
        this.capacity = capacity;
        this.licensePlate = licensePlate;
        this.color = color;
        this.truckBodyWork = truckBodyWork.toString();
    }

}

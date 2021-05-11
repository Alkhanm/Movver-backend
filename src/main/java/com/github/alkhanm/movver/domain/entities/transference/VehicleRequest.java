package com.github.alkhanm.movver.domain.entities.transference;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.domain.enums.VehicleTruckBodyEnum;
import lombok.Getter;

public class VehicleRequest {
    //Aqui o modelo do veiculo é retornado apenas como seu valor textual (enum -> string)
    @Getter final VehicleModelEnum model;
    @Getter final int capacity;
    @Getter final String licensePlate;
    @Getter final String color;
    @Getter final VehicleTruckBodyEnum truckBodyWork;

    public VehicleRequest(
            String model,
            int capacity,
            String licensePlate,
            String color,
            VehicleTruckBodyEnum truckBodyWork) {
        this.model = VehicleModelEnum.to(model);
        this.capacity = capacity;
        this.licensePlate = licensePlate;
        this.color = color;
        this.truckBodyWork = truckBodyWork;
    }

}

package com.github.alkhanm.movver.domain.entities.transference;

import com.github.alkhanm.movver.domain.enums.VehicleModelEnum;
import com.github.alkhanm.movver.domain.enums.VehicleTruckBodyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString
public class VehicleResponse {
    //Aqui o modelo do veiculo é retornado apenas como seu valor textual (enum -> string)
    final String model;
    final String truckBodyWork;
    final int capacity;
    final String licensePlate;
    final String color;
}

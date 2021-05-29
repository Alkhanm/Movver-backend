package com.github.alkhanm.movver.domain.transference;

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

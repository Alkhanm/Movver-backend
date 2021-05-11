package com.github.alkhanm.movver.domain.enums;

import java.util.Arrays;

public enum VehicleTruckBodyEnum {
    OPEN ("Aberta"),
    CLOSED  ("Fechada"),
    ANY ("Não especificado");

    private final String value;

    VehicleTruckBodyEnum(String enumValue) {
        value = enumValue;
    }

    public static VehicleTruckBodyEnum to(String value){
        return Arrays.stream(VehicleTruckBodyEnum.values())
                .filter(v -> v.toString().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nem um tipo enumerável corresponde a este valor: " + value));
    }

    @Override
    public String toString(){
        return value;
    }

}


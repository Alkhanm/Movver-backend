package com.github.alkhanm.movver.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public enum VehicleModelEnum {
    TYPE1("Veículo utilitário"),
    TYPE2("VUC"),
    TYPE3("Caminhão Toco ou Semi-pesado"),
    TYPE4("Veículo utilitário"),
    TYPE5("Caminhão Truck ou Eixo duplo pesado"),
    TYPE6("Bitruck"),
    TYPE7("Bitrem");

    private final String value;

    VehicleModelEnum(String enumValue) {
        value = enumValue;
    }

    public static VehicleModelEnum to(String value){
        return Arrays.stream(VehicleModelEnum.values())
                .filter(v -> v.toString().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nem um tipo enumerável corresponde a este valor: " + value));
    }
    @Override public String toString(){
        return value;
    }
}


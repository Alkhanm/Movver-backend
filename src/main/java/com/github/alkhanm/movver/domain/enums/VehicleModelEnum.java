package com.github.alkhanm.movver.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public enum VehicleModelEnum {
    TYPE_1("Veículo utilitário"),
    TYPE_2("VUC"),
    TYPE_3("Caminhão Toco ou Semi-pesado"),
    TYPE_4("Veículo utilitário"),
    TYPE_5("Caminhão Truck ou Eixo duplo pesado"),
    TYPE_6("Bitruck"),
    TYPE_7("Bitrem");

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

    @Override
    public String toString(){
        return value;
    }

    public static void main(String[] args) {
        VehicleModelEnum enumm = VehicleModelEnum.to("VUC");
        String enumValue = VehicleModelEnum.valueOf(enumm.name()).toString();
        System.out.println(enumValue);
        System.out.println(enumm.name());

    }
}


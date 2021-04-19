package com.github.alkhanm.movver.domain.enums;

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

    @Override
    public String toString(){
        return value;
    }
}

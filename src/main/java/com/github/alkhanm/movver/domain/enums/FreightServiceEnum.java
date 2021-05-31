package com.github.alkhanm.movver.domain.enums;

import java.util.Arrays;

public enum FreightServiceEnum {
    MATERIAL_TRANSPORT("Transporte de Materiais"),
    HOME_MOVING("Mudança");

    private final String value;

    FreightServiceEnum(String enumValue) {
        value = enumValue;
    }

    @Override
    public String toString(){
        return value;
    }

    public static FreightServiceEnum of(String value){
        return Arrays.stream(FreightServiceEnum.values())
                .filter(v -> v.toString().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nem um tipo enumerável corresponde a este valor: " + value));
    }
}


package com.github.alkhanm.movver.domain.enums;

import java.util.Arrays;

public enum FreightStatusEnum {
    WAITING("Aguardando"),
    CANCELED("Cancelada"),
    FINISHED("Finalizada");

    private final String value;

    FreightStatusEnum(String enumValue) {
        value = enumValue;
    }

    @Override public String toString(){
        return value;
    }
    public static FreightStatusEnum of(String value){
        return Arrays.stream(FreightStatusEnum.values())
                .filter(v -> v.toString().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nem um tipo enumerável corresponde a este valor: " + value));
    }
}


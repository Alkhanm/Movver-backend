package com.github.alkhanm.movver.domain.enums;

public enum FreightStatusEnum {
    UNCONFIRMED("Não confirmada"),
    CONFIRMED("Confirmado"),
    STARTED("Iniciado"),
    FINISHED("Finalizada"),
    CANCELED("Cancelada");

    private final String value;

    FreightStatusEnum(String enumValue) {
        value = enumValue;
    }

    @Override public String toString(){
        return value;
    }
}


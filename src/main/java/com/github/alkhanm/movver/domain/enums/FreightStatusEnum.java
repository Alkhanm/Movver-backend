package com.github.alkhanm.movver.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public enum FreightStatusEnum {
    TYPE_1("Aguardando"),
    TYPE_2("Cancelada"),
    TYPE_3("Finalizada");

    private final String value;

    FreightStatusEnum(String enumValue) {
        value = enumValue;
    }

    @Override
    public String toString(){
        return value;
    }
}


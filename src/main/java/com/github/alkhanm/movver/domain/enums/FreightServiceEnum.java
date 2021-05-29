package com.github.alkhanm.movver.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public enum FreightServiceEnum {
    TYPE_1("Mudança"),
    TYPE_2("Transporte de Materiais");

    private final String value;

    FreightServiceEnum(String enumValue) {
        value = enumValue;
    }

    @Override
    public String toString(){
        return value;
    }
}


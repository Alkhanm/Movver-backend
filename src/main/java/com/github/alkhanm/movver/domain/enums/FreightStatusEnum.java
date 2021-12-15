package com.github.alkhanm.movver.domain.enums;

import com.github.alkhanm.movver.services.exceptions.ResourceNotFoundException;

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
    
    public static FreightStatusEnum create(String name){
        try {
            return FreightStatusEnum.valueOf(name);
        } catch (IllegalArgumentException ex) {
            return switch (name) {
                case "unconfirmed"  -> FreightStatusEnum.UNCONFIRMED;
                case "confirmed" -> FreightStatusEnum.CONFIRMED;
                case "started" -> FreightStatusEnum.STARTED;
                case "finished" -> FreightStatusEnum.FINISHED;
                case "canceled" -> FreightStatusEnum.CANCELED;
                default -> throw new IllegalArgumentException("Nem um status corresponde a essa sequência de caracteres");
            };
        }
    }
    

    public static void main(String[] args) {
        FreightStatusEnum status = FreightStatusEnum.valueOf("UNCONFIRMED");
        System.out.println(status);
    }
}


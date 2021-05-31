package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;

public class FreightUnconfirmedStatus implements FreightStatus {
    private final Freight freight;

    public FreightUnconfirmedStatus(Freight freight){
        this.freight = freight;
    }

    @Override public void confirm() {
        freight.calculatePrice();
        System.out.println("Frete iniciado: " + freight);
    }

    @Override
    public void start() {

    }

    @Override
    public void finish() {

    }

    @Override
    public void cancel() {
        throw new InvalidActionException("Erro ao cancelar frete: O frete ainda não foi iniciado");
    }
}

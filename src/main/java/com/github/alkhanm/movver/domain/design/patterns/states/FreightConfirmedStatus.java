package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;

public class FreightConfirmedStatus implements FreightStatus {
    private final Freight freight;

    public FreightConfirmedStatus(Freight freight){
        this.freight = freight;
    }

    @Override public void start() {
        freight.calculatePrice();
    }

    @Override public void finish() {

    }

    @Override public void cancel() {

    }

    @Override public void confirm() {
        throw new InvalidActionException("Erro ao confirmar o frete: o frete já foi confirmado");
    }
}

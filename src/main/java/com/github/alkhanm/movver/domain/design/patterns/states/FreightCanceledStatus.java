package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;

public class FreightCanceledStatus implements FreightStatus {
    private Freight freight;

    public FreightCanceledStatus(Freight freight){
        this.freight = freight;
    }


    @Override public void confirm() {
        throw new InvalidActionException("O frete já foi cancelado");
    }

    @Override public void start() {
        throw new InvalidActionException("O frete já foi cancelado");
    }

    @Override public void finish() {
        throw new InvalidActionException("O frete já foi cancelado");
    }

    @Override public void cancel() {
       throw new InvalidActionException("O frete já foi cancelado");
    }
}

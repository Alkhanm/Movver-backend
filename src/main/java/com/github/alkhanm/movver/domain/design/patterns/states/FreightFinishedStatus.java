package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;

public class FreightFinishedStatus implements FreightStatus {
    private final Freight freight;

    public FreightFinishedStatus(Freight freight){
        this.freight = freight;
    }

    @Override public void confirm() {

    }

    @Override
    public void start() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void finish() {
        throw new InvalidActionException("Erro ao finalizar o frete: O frete já foi finalizado");
    }
}

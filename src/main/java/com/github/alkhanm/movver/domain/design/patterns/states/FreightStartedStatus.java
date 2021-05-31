package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;

public class FreightStartedStatus implements FreightStatus {
    private final Freight freight;

    public FreightStartedStatus(Freight freight){
        this.freight = freight;
    }

    @Override public void confirm() {

    }


    @Override
    public void finish() {

    }

    @Override public void cancel() {
        throw new InvalidActionException("Erro ao cancelar frete: Não é possível cancelar um frete em andamento");
    }

    @Override public void start() {
        throw new InvalidActionException("Erro ao iniciar o frete: O frete já foi iniciado");
    }
}

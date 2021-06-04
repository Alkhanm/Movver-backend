package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;

public class FreightStartedState implements FreightState {
    private final Freight freight;

    public FreightStartedState(Freight freight){
        this.freight = freight;
    }

    @Override public FreightStatusEnum getName() {
        return FreightStatusEnum.STARTED;
    }

    @Override
    public void finish() {
        freight.setState(new FreightFinishedState(freight));
    }

    @Override public void cancel() {
        throw new InvalidActionException("Erro ao cancelar frete: Não é possível cancelar um frete em andamento");
    }
    @Override public void confirm() {
        throw new InvalidActionException("Erro ao confirmar o frete: O frete já foi confirmado");
    }
    @Override public void start() {
        throw new InvalidActionException("Erro ao iniciar o frete: O frete já foi iniciado");
    }
}

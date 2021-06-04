package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;

public class FreightUnconfirmedState implements FreightState {
    private final Freight freight;

    public FreightUnconfirmedState(Freight freight){
        this.freight = freight;
    }

    @Override public FreightStatusEnum getName() {
        return FreightStatusEnum.UNCONFIRMED;
    }

    @Override public void confirm() {
        freight.calculatePrice();
        freight.setState(new FreightConfirmedState(freight));
    }

    @Override
    public void start() {
       throw new InvalidActionException("Erro ao iniciar frete: O frete ainda não foi confirmado");
    }
    @Override
    public void finish() {
       throw new InvalidActionException("Erro ao finalizar frete: O frete ainda não foi iniciado");
    }
    @Override
    public void cancel() {
       throw new InvalidActionException("Erro ao cancelar frete: O frete ainda não foi iniciado");
    }
}

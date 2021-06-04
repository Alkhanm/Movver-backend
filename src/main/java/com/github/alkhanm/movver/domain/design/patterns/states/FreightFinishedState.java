package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;

public class FreightFinishedState implements FreightState {
    private final Freight freight;

    public FreightFinishedState(Freight freight){
        this.freight = freight;
    }

    @Override public FreightStatusEnum getName() {
        return FreightStatusEnum.FINISHED;
    }

    @Override
    public void confirm() {
        throw new InvalidActionException("O frete já foi finalizado");
    }
    @Override
    public void start() {
        throw new InvalidActionException("O frete já foi finalizado");
    }
    @Override
    public void cancel() {
        throw new InvalidActionException("O frete já foi finalizado");
    }
    @Override
    public void finish() {
        throw new InvalidActionException("O frete já foi finalizado");
    }
}

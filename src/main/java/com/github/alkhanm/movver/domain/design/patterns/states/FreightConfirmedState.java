package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.Freight;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import com.github.alkhanm.movver.domain.exceptions.InvalidActionException;
import com.github.alkhanm.movver.utils.DateUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FreightConfirmedState implements FreightState {
    private final Freight freight;

    public FreightConfirmedState(Freight freight){
        this.freight = freight;
    }

    @Override public FreightStatusEnum getName() {
        return FreightStatusEnum.CONFIRMED;
    }

    //Envia o frete para o estado iniciado (FreightStartedState)
    @Override public void start() {
        //freight.setStartDate(DateUtil.dateToMilliseconds(LocalDateTime.now()));
        freight.setState(new FreightStartedState(freight));
    }

    //Envia o frete para o estado inicial(FreightUncofirmedState)
    @Override public void cancel() {
        freight.setState(new FreightUnconfirmedState(freight));
    }

    @Override
    public void finish() {
        throw new InvalidActionException("Erro ao finalizar o frete: o frete ainda não foi iniciado");
    }

    @Override
    public void confirm() {
        throw new InvalidActionException("Erro ao confirmar o frete: o frete já foi confirmado");
    }
}

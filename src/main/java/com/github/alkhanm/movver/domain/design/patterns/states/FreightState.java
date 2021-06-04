package com.github.alkhanm.movver.domain.design.patterns.states;

import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;

/* Estado: frete não confirmado -> (confirmado)
 * Estado: frete confirmado -> (esperando, não confirmado)
 * Estado: frete iniciado -> (finalizado)
 * Estado: frete finalizado -> (não confirmado) */
public interface FreightState {
    FreightStatusEnum getName();
    void confirm();
    void start();
    void finish();
    void cancel();
}

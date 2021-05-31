package com.github.alkhanm.movver.domain.design.patterns.states;

public interface FreightStatus {
    void confirm();
    void start();
    void finish();
    void cancel();
}

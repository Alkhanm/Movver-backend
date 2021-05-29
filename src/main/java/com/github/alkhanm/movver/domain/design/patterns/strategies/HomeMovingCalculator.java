package com.github.alkhanm.movver.domain.design.patterns.strategies;

import com.github.alkhanm.movver.domain.Freight;

public class HomeMovingCalculator implements FreightCalculator {
    @Override public double calculate(Freight freight) {
        return 0;
    }
}
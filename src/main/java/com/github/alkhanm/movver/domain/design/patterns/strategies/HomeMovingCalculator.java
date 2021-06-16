package com.github.alkhanm.movver.domain.design.patterns.strategies;

import com.github.alkhanm.movver.domain.Freight;

public class HomeMovingCalculator implements FreightCalculator {
    @Override public double calculate(Freight freight) {
        double price = (freight.getDistance() * 10.0);
        return price < 49 ? 50.0 : price;
    }
}
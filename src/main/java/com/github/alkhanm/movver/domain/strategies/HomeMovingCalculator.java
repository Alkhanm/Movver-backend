package com.github.alkhanm.movver.domain.strategies;

import com.github.alkhanm.movver.domain.Freight;

public class HomeMovingCalculator implements FreightCalculator {
    @Override public double calculate(Freight freight) {
        double price = (freight.getDistance() * 10.0);
        return price > 49 ? price : 50.0;
    }
}
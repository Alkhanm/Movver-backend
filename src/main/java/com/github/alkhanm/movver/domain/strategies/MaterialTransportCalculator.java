package com.github.alkhanm.movver.domain.strategies;

import com.github.alkhanm.movver.domain.Freight;

public class MaterialTransportCalculator implements FreightCalculator {
    @Override public double calculate(Freight freight) {
        double price = (freight.getDistance() * 2.0) * (freight.getWeight() / 1000.0);
        return price > 59 ? price : 60.0;
    }
}
package com.github.alkhanm.movver.domain.design.patterns.strategies;

import com.github.alkhanm.movver.domain.Freight;

public class MaterialTransportCalculator implements FreightCalculator {
    @Override public double calculate(Freight freight) {
        return (freight.getDistance() * 13.0) * (freight.getWeight() / 1000.0);
    }
}

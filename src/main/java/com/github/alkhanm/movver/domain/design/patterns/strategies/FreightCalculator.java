package com.github.alkhanm.movver.domain.design.patterns.strategies;

import com.github.alkhanm.movver.domain.Freight;

public interface FreightCalculator {
    double calculate(Freight freight);
}

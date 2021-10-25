package com.github.alkhanm.movver.domain.strategies;

import com.github.alkhanm.movver.domain.Freight;

public interface FreightCalculator {
    double calculate(Freight freight);
}

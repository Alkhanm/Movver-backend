package com.github.alkhanm.movver.domain.entities;

import com.github.alkhanm.movver.domain.entities.transference.ClientResponse;
import com.github.alkhanm.movver.domain.entities.transference.DriverResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString
public class FreightResponse {
    final Long id;
    final String startDate, endDate;
    final Double price, distance;
    final Location origin, destination;
    final ClientResponse client;
    final DriverResponse driver;
}

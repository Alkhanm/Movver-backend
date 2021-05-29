package com.github.alkhanm.movver.domain.transference;

import com.github.alkhanm.movver.domain.Location;
import com.github.alkhanm.movver.domain.enums.FreightServiceEnum;
import com.github.alkhanm.movver.domain.enums.FreightStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString
public class FreightResponse {
    final Long id;
    final String startDate, endDate;
    final String description;
    final int weight = 0;
    final double price, distance = 0.0;
    final Location origin, destination;
    final ClientResponse client;
    final DriverResponse driver;
    final FreightStatusEnum status;
    final FreightServiceEnum service;

    public String getService() {
        return service.toString();
    }

    public String getStatus() {
        return status.toString();
    }
}
